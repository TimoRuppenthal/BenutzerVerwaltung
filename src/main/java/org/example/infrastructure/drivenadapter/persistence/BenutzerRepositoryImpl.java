package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Benutzer;
import org.example.domain.BenutzerRepository;

import java.util.List;
import java.util.Properties;

public class BenutzerRepositoryImpl implements BenutzerRepository {
    private final IRepository<Benutzer, String> repository;

    public BenutzerRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(Benutzer.class, Benutzer::getEmailAdresse, properties);
    }
    @Override
    public List<Benutzer> getAll() {
        return repository.get();
    }

    @Override
    public void remove(Benutzer benutzer) {
        repository.remove(benutzer.getEmailAdresse());

    }


    @Override
    public void add(Benutzer benutzer) {
        repository.add(benutzer);

    }

}
