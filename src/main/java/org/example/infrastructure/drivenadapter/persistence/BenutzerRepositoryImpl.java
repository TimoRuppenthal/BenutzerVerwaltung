package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Benutzer;
import org.example.domain.BenutzerRepository;
import org.example.domain.EmailAdresse;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@DrivenAdapter
public class BenutzerRepositoryImpl implements BenutzerRepository {
    private final IRepository<Benutzer, EmailAdresse> repository;

    public BenutzerRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(Benutzer.class, Benutzer::getEmailAdresse, properties);
    }
    @Override
    public List<Benutzer> getAll() {
        return repository.get();
    }

    @Override
    public void remove(EmailAdresse emailAdresse) {
        repository.remove(emailAdresse);

    }


    @Override
    public void add(Benutzer benutzer) {
        repository.add(benutzer);

    }

    @Override
    public Optional<Benutzer> get(EmailAdresse emailAdresse) {
        return repository.get(emailAdresse);
    }

    @Override
    public void update(Benutzer benutzer) {
        repository.update(benutzer);
    }

}
