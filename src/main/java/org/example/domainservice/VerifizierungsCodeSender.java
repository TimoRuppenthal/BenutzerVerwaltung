package org.example.domainservice;

import io.jexxa.addend.applicationcore.InfrastructureService;
import org.example.domain.VerifizierungsCodeVerschickt;
@InfrastructureService
public interface VerifizierungsCodeSender {

    void send(VerifizierungsCodeVerschickt verifizierungsCodeVerschickt);
}
