package org.example.domainservice;

import org.example.domain.Benutzer;
import org.example.domain.BenutzerRepository;

import java.util.List;

public class StammdatenService {
    private static final Benutzer TIMO = new Benutzer("Ruppenthal", "Timo", "ruppenthal.timo@gmail.com");
    private static final Benutzer MICHAEL = new Benutzer("Repplinger", "Michael", "michael.repplinger@gmail.com");
    private final BenutzerRepository benutzerRepository;

    public StammdatenService(BenutzerRepository benutzerRepository) {
        this.benutzerRepository = benutzerRepository;
    }

    public void initStammdaten(){

        List<Benutzer> alleBenutzer = benutzerRepository.getAll();
        if(!alleBenutzer.contains(TIMO)){
            benutzerRepository.add(TIMO);
        }
        if(!alleBenutzer.contains(MICHAEL)){
            benutzerRepository.add(MICHAEL);
        }
        benutzerRepository
                .getAll()
                .forEach( element -> System.out.println(element.getVorname()));
    }
}
