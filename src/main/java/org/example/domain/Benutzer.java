package org.example.domain;

import java.util.Objects;

public class Benutzer {
    private final String nachname;
    private final String vorname;

    private final String emailAdresse;

    public Benutzer(String nachname, String vorname, String emailAdresse){
        this.nachname = nachname;
        this.vorname = vorname;
        this.emailAdresse = emailAdresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benutzer benutzer = (Benutzer) o;
        return Objects.equals(nachname, benutzer.nachname) && Objects.equals(vorname, benutzer.vorname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nachname, vorname);
    }

    @SuppressWarnings("unused")
    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getEmailAdresse(){ return emailAdresse; }

}
