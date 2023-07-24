package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.Benutzer;
import org.example.domain.BenutzerDaten;
import org.example.domain.BenutzerRepository;
import org.example.domain.EmailAdresse;

import java.util.List;

@DomainService
public class StammdatenService {

    private final BenutzerRepository benutzerRepository;

    public StammdatenService(BenutzerRepository benutzerRepository) {
        this.benutzerRepository = benutzerRepository;
    }

    public void initStammdaten(){

        final Benutzer TIMO = new Benutzer(new BenutzerDaten("Ruppenthal", "Timo"), new EmailAdresse("ruppenthal.timo@gmail.com"));
        final Benutzer MICHAEL = new Benutzer(new BenutzerDaten("Repplinger", "Michael"), new EmailAdresse( "michael.repplinger@gmail.com"));
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
