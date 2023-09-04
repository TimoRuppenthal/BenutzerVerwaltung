package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;

import java.util.List;

@ApplicationService
public class BenutzerVerwaltung {

    private final BenutzerRepository benutzerRepository;
    private  final RegistrierungsDatenRepository registrierungsDatenRepository;

    public void add (EmailAdresse emailAdresse, BenutzerDaten benutzerDaten){
        benutzerRepository.add(new Benutzer(benutzerDaten, emailAdresse));
    }

    @SuppressWarnings("unused")
    public void delete (EmailAdresse emailAdresse){
        benutzerRepository.remove(emailAdresse);
    }

    public List<EmailAdresse> get (){
        return benutzerRepository.getAll()
                .stream()
                .map(Benutzer::getEmailAdresse)
                .toList();
    }

    public BenutzerVerwaltung (BenutzerRepository benutzerRepository, RegistrierungsDatenRepository registrierungsDatenRepository){
        this.benutzerRepository = benutzerRepository;
        this.registrierungsDatenRepository = registrierungsDatenRepository;
    }

    public void registriere(EmailAdresse emailAdresse, BenutzerDaten benutzerDaten){
        registrierungsDatenRepository.add(new RegistrierungsDaten(emailAdresse, benutzerDaten));
        //TODO: BestätigungsCode verschicken
    }

    public void verifiziere(EmailAdresse emailAdresse, VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        RegistrierungsDaten registrierungsDaten = registrierungsDatenRepository.get(emailAdresse);
        registrierungsDaten.verifiziere(verifizierungsCode);

        add(emailAdresse, registrierungsDaten.getBenutzerDaten());
        registrierungsDatenRepository.remove(emailAdresse);
    }
}
