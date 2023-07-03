package org.example.domain;

import java.util.List;

public interface BenutzerRepository {
    List<Benutzer> getAll();

    void remove(Benutzer benutzer);

    void add(Benutzer benutzer);
}
