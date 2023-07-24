package org.example.domain;

import io.jexxa.addend.applicationcore.ValueObject;

@ValueObject
public record BenutzerDaten(String nachname, String vorname) {
}
