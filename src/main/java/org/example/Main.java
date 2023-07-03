package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.Benutzer;
import org.example.domain.BenutzerVerwaltung;

import java.util.List;

public class Main {
    @SuppressWarnings("java:S106")// Okay da Demoprojekt
    public static void main(String[] args) {
        BenutzerVerwaltung benutzerVerwaltung = new BenutzerVerwaltung();
        Benutzer timo = new Benutzer("Ruppenthal", "Timo");
        Benutzer michael = new Benutzer("Repplinger", "Michael");

        benutzerVerwaltung.add(timo);
        benutzerVerwaltung.add(michael);
        List<Benutzer> alleBenutzer = benutzerVerwaltung.get();
        alleBenutzer.forEach( element -> System.out.println(element.getVorname()));
        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(benutzerVerwaltung)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}