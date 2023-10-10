package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;
@SuppressWarnings("unused")
@Repository
public interface RegistrierungsDatenRepository {
    List<RegistrierungsDaten> getAll();

    void remove(EmailAdresse emailAdresse);

    void add(RegistrierungsDaten registrierungsDaten);

    Optional<RegistrierungsDaten> get(EmailAdresse emailAdresse);
}
