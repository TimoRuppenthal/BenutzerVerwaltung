package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.UUID;

import static org.example.domain.DomainEventPublisher.publish;
@SuppressWarnings("unused")
@Aggregate
public class RegistrierungsDaten {
    private final BenutzerDaten benutzerDaten;
    private final EmailAdresse emailAdresse;

    private final VerifizierungsCode verifizierungsCode;

    public RegistrierungsDaten(EmailAdresse emailAdresse, BenutzerDaten benutzerDaten) {
        this.emailAdresse = emailAdresse;
        this.benutzerDaten = benutzerDaten;
        this.verifizierungsCode = new VerifizierungsCode(UUID.randomUUID().toString());
        sendVerifizierungsCode();
    }

    public VerifizierungsCode getVerifizierungsCode() {
        return verifizierungsCode;
    }

    public BenutzerDaten getBenutzerDaten() {
        return benutzerDaten;
    }
    public void verifiziere(VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        if (this.verifizierungsCode != verifizierungsCode) {
            throw new UngueltigerVerifizierungsCode();
        }
    }

    public void sendVerifizierungsCode(){
        publish(new VerifizierungsCodeVerschickt(emailAdresse, verifizierungsCode));
    }
    @AggregateID
    public EmailAdresse getEmailAdresse() {
        return emailAdresse;
    }
}
