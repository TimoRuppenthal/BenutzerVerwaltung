package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.BenutzerRepository;
import org.example.applicationservice.BenutzerVerwaltung;
import org.example.domainservice.StammdatenService;
import org.example.infrastructure.drivenadapter.persistence.BenutzerRepositoryImpl;

import java.util.Properties;

public class Main {
    @SuppressWarnings("java:S106")// Okay da Demoprojekt
    public static void main(String[] args) {
        BenutzerRepository benutzerRepository = new BenutzerRepositoryImpl(new Properties());

        BenutzerVerwaltung benutzerVerwaltung = new BenutzerVerwaltung(benutzerRepository);

        StammdatenService stammdatenService = new StammdatenService(benutzerRepository);
        stammdatenService.initStammdaten();

        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(benutzerVerwaltung)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}