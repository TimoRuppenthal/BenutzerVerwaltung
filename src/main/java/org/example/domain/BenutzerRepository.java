package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;

@Repository
public interface BenutzerRepository {
    List<Benutzer> getAll();

    void remove(EmailAdresse emailAdresse);

    void add(Benutzer benutzer);
}
