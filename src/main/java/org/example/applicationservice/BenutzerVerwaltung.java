package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.Benutzer;
import org.example.domain.BenutzerDaten;
import org.example.domain.BenutzerRepository;
import org.example.domain.EmailAdresse;

import java.util.List;

@ApplicationService
public class BenutzerVerwaltung {

    private final BenutzerRepository benutzerRepository;

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

    public BenutzerVerwaltung (BenutzerRepository benutzerRepository){
        this.benutzerRepository = benutzerRepository;
    }
}
