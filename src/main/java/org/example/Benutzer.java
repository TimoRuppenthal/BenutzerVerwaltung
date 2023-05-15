package org.example;

public class Benutzer {
    private final String nachname;
    private final String vorname;

    public Benutzer(String nachname, String vorname){
        this.nachname = nachname;
        this.vorname = vorname;
    }

    @SuppressWarnings("unused")
    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }
}
