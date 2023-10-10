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
    @SuppressWarnings("java:S106")
    public void initStammdaten(){

        final Benutzer timo = new Benutzer(new BenutzerDaten("Ruppenthal", "Timo"), new EmailAdresse("ruppenthal.timo@gmail.com"));
        final Benutzer michael = new Benutzer(new BenutzerDaten("Repplinger", "Michael"), new EmailAdresse( "michael.repplinger@gmail.com"));
        List<Benutzer> alleBenutzer = benutzerRepository.getAll();
        if(!alleBenutzer.contains(timo)){
            benutzerRepository.add(timo);
        }
        if(!alleBenutzer.contains(michael)){
            benutzerRepository.add(michael);
        }
        benutzerRepository
                .getAll()
                .forEach( element -> System.out.println(element.getVorname()));
    }
}
