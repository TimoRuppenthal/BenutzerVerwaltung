package org.example.infrastructure.drivenadapter.messaging;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.messaging.MessageSender;
import org.example.domain.VerifizierungsCodeVerschickt;
import org.example.domainservice.VerifizierungsCodeSender;

import java.util.Properties;

import static io.jexxa.infrastructure.MessageSenderManager.getMessageSender;

@DrivenAdapter
public class VerifizierungsCodeSenderImpl implements VerifizierungsCodeSender {


    public static final String TOPIC = "BenutzerVerifizierungsEmail";
    private final MessageSender messageSender;

    public VerifizierungsCodeSenderImpl(Properties properties){
        this.messageSender = getMessageSender(VerifizierungsCodeSender.class, properties);
    }
    public void send(VerifizierungsCodeVerschickt verifizierungsCodeVerschickt){
        messageSender
                .send(verifizierungsCodeVerschickt)
                .toTopic(TOPIC)
                .asJson();
    }
}
