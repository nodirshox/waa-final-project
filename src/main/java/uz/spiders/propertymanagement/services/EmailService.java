package uz.spiders.propertymanagement.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public final class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(String  toEmail, String subject, String body){
        log.debug("Email service triggered");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Notification to owner about new application submitted");
        message.setText(body);
        mailSender.send(message);
        log.debug("Sent email to owner on application creation");
    }
}
