package org.example.domain;

import io.jexxa.addend.applicationcore.DomainEvent;

@DomainEvent
public record VerifizierungsCodeVerschickt(EmailAdresse emailAdresse, VerifizierungsCode verifizierungsCode) {
}
