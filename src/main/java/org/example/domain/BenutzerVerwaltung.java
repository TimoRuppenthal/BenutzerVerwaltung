package org.example.domain;

import org.example.domain.Benutzer;

import java.util.ArrayList;
import java.util.List;

public class BenutzerVerwaltung {

    private final BenutzerRepository benutzerRepository;

    public void add (Benutzer benutzer){
        benutzerRepository.add(benutzer);
    }

    @SuppressWarnings("unused")
    public void delete (Benutzer benutzer){
        benutzerRepository.remove(benutzer);
    }

    public List<Benutzer> get (){
        return benutzerRepository.getAll();
    }

    public BenutzerVerwaltung (BenutzerRepository benutzerRepository){
        this.benutzerRepository = benutzerRepository;
    }
}
