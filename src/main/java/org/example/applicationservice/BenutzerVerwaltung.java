package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;
import org.example.domainservice.VerifizierungsCodeSender;

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


    }

    public void verifiziere(EmailAdresse emailAdresse, VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        RegistrierungsDaten registrierungsDaten = registrierungsDatenRepository.get(emailAdresse).orElseThrow();
        registrierungsDaten.verifiziere(verifizierungsCode);

        add(emailAdresse, registrierungsDaten.getBenutzerDaten());
        registrierungsDatenRepository.remove(emailAdresse);
    }
    public  void aktualisiereBenutzerDaten(EmailAdresse emailAdresse, BenutzerDaten benutzerDaten){
        Benutzer benutzer = benutzerRepository.get(emailAdresse).orElseThrow();
        benutzer.setBenutzerDaten(benutzerDaten);
        benutzerRepository.update(benutzer);
    }
}
