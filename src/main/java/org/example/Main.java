package org.example;

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
    }
}