package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Benutzer {
    private final String nachname;
    private final String vorname;

    private final EmailAdresse emailAdresse;

    public Benutzer(String nachname, String vorname, String emailAdresse){
        this.nachname = nachname;
        this.vorname = vorname;
        this.emailAdresse = new EmailAdresse(emailAdresse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benutzer benutzer = (Benutzer) o;
        return Objects.equals(getEmailAdresse(), benutzer.getEmailAdresse());
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

    @AggregateID
    public EmailAdresse getEmailAdresse(){ return emailAdresse; }

}
