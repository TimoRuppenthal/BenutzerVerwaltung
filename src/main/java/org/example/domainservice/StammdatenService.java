package org.example.domainservice;

import org.example.domain.Benutzer;
import org.example.domain.BenutzerRepository;

import java.util.List;

public class StammdatenService {

    private final BenutzerRepository benutzerRepository;

    public StammdatenService(BenutzerRepository benutzerRepository) {
        this.benutzerRepository = benutzerRepository;
    }

    public void initStammdaten(){

        List<Benutzer> alleBenutzer = benutzerRepository.getAll();
        if(!alleBenutzer.contains(new Benutzer ("Ruppenthal", "Timo", "ruppenthal.timo@gmail.com"))){
            benutzerRepository.add(new Benutzer ("Ruppenthal", "Timo", "ruppenthal.timo@gmail.com"));
        }
        if(!alleBenutzer.contains(new Benutzer("Repplinger", "Michael", "michael.repplinger@gmail.com"))){
            benutzerRepository.add(new Benutzer("Repplinger", "Michael", "michael.repplinger@gmail.com"));
        }
        benutzerRepository
                .getAll()
                .forEach( element -> System.out.println(element.getVorname()));
    }
}
