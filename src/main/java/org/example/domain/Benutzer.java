package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Benutzer {

    private BenutzerDaten benutzerDaten;

    private final EmailAdresse emailAdresse;

    public Benutzer(BenutzerDaten benutzerDaten, EmailAdresse emailAdresse){
        this.benutzerDaten = benutzerDaten;
        this.emailAdresse = emailAdresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benutzer benutzer = (Benutzer) o;
        return Objects.equals(getEmailAdresse(), benutzer.getEmailAdresse());
    }

    @SuppressWarnings("unused")
    public String getNachname() {
        return benutzerDaten.nachname();
    }

    public String getVorname() {
        return benutzerDaten.vorname();
    }

    @AggregateID
    public EmailAdresse getEmailAdresse(){ return emailAdresse; }

    public void setBenutzerDaten(BenutzerDaten benutzerDaten){
        this.benutzerDaten = benutzerDaten;
    }

}
