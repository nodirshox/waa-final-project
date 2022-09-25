package uz.spiders.propertymanagement.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class EmailEventProducer {

    @Value("${queues.email-queue}")
    private String emailQueue;
    private final JmsTemplate jmsTemplate;

    public void send(){
        String ownerEmail = "javohirnazarov99@gmail.com";
        log.debug("Sending email to owner with email: {}", ownerEmail);
        jmsTemplate.convertAndSend(emailQueue, ownerEmail);
    }
}
