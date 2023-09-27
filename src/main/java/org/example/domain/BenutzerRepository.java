package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BenutzerRepository {
    List<Benutzer> getAll();

    void remove(EmailAdresse emailAdresse);

    void add(Benutzer benutzer);

    Optional<Benutzer> get(EmailAdresse emailAdresse);

    void update(Benutzer benutzer);
}
