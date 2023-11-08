package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RegistrierungsDatenTest {

    @Test
    void testErstelleVerifizierungsCode(){
        //Arrange
        var emailAdresse = new EmailAdresse("gsd@icloud.com");
        var benutzerDaten = new BenutzerDaten("Hans","Johannes");
        var objectUnderTest = new RegistrierungsDaten(emailAdresse, benutzerDaten);
        var receivedDomainEvents = new ArrayList<VerifizierungsCodeVerschickt>();
        DomainEventPublisher.subscribe(VerifizierungsCodeVerschickt.class, receivedDomainEvents::add);

        //Act
        objectUnderTest.sendVerifizierungsCode();


        //Assert
        assertEquals(1, receivedDomainEvents.size());
        //Note: A UUID actually a 128 bit value (2 long). To represent 128 bit into hex string there will be 128/4=32 char (each char is 4bit long). In string format it also contains 4 (-) that's why the length is 36.
        assertEquals(36, receivedDomainEvents.get(0).verifizierungsCode().verifizierungsCode().length());
    }

}