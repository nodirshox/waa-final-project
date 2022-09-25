package uz.spiders.propertymanagement.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import uz.spiders.propertymanagement.services.EmailService;

@Slf4j
@RequiredArgsConstructor
@Component
public class EmailEventListener {
    private final EmailService emailService;


    @JmsListener(destination = "${queues.email-queue}")
    public void listen(String email){
        log.debug("Received email event for {} ", email);
        emailService.sendEmail(email, "Dummy subject", "Dummy text, think about refactoring once you get this email");
    }
}
