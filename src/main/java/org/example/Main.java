package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.applicationservice.BenutzerVerwaltung;
import org.example.domainservice.DomainEventSender;
import org.example.domainservice.StammdatenService;

public class Main {
    @SuppressWarnings("java:S106")// Okay da Demoprojekt
    public static void main(String[] args) {

        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                .bootstrap(StammdatenService.class).with(StammdatenService::initStammdaten)
                .bootstrap(DomainEventSender.class).and()
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(BenutzerVerwaltung.class)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}