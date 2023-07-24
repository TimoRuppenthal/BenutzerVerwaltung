package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.Benutzer;
import org.example.domain.BenutzerRepository;

import java.util.List;

@DomainService
public class StammdatenService {

    private final BenutzerRepository benutzerRepository;

    public StammdatenService(BenutzerRepository benutzerRepository) {
        this.benutzerRepository = benutzerRepository;
    }

    public void initStammdaten(){

        final Benutzer TIMO = new Benutzer("Ruppenthal", "Timo", "ruppenthal.timo@gmail.com");
        final Benutzer MICHAEL = new Benutzer("Repplinger", "Michael", "michael.repplinger@gmail.com");
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
