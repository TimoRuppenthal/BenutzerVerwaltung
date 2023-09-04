package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.VerifizierungsCode;
import org.example.domain.VerifizierungsCodeVerschickt;

import static org.example.domain.DomainEventPublisher.subscribe;

@DomainService
public class DomainEventSender {
    public DomainEventSender(VerifizierungsCodeSender verifizierungsCodeSender) {
        subscribe(VerifizierungsCodeVerschickt.class, verifizierungsCodeSender::send);
    }
}
