package org.example.domain;

import org.example.domain.Benutzer;

import java.util.ArrayList;
import java.util.List;

public class BenutzerVerwaltung {
    private final List<Benutzer> benutzerList = new ArrayList<>();

    public void add (Benutzer benutzer){
        benutzerList.add(benutzer);
    }

    @SuppressWarnings("unused")
    public void delete (Benutzer benutzer){
        benutzerList.remove(benutzer);
    }

    public List<Benutzer> get (){
        return benutzerList;
    }
}
