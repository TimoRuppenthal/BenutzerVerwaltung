package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.Benutzer;
import org.example.domain.BenutzerRepository;
import org.example.domain.EmailAdresse;

import java.util.List;

@ApplicationService
public class BenutzerVerwaltung {

    private final BenutzerRepository benutzerRepository;

    /*public void add (Benutzer benutzer){
        benutzerRepository.add(benutzer);
    }

    @SuppressWarnings("unused")
    public void delete (Benutzer benutzer){
        benutzerRepository.remove(benutzer);
    }*/

    public List<EmailAdresse> get (){
        return benutzerRepository.getAll().stream().map(Benutzer::getEmailAdresse).toList();
    }

    public BenutzerVerwaltung (BenutzerRepository benutzerRepository){
        this.benutzerRepository = benutzerRepository;
    }
}
