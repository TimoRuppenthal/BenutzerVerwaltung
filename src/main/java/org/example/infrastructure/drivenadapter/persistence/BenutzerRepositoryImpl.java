package org.example.infrastructure.drivenadapter.persistence;

import org.example.domain.Benutzer;
import org.example.domain.BenutzerRepository;

import java.util.ArrayList;
import java.util.List;

public class BenutzerRepositoryImpl implements BenutzerRepository {
    private final List<Benutzer> benutzerList = new ArrayList<>();
    @Override
    public List<Benutzer> getAll() {
        return benutzerList;
    }

    @Override
    public void remove(Benutzer benutzer) {
        benutzerList.remove(benutzer);

    }

    @Override
    public void add(Benutzer benutzer) {
        benutzerList.add(benutzer);

    }
}
