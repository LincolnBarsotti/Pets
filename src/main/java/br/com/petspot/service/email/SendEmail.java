package br.com.petspot.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    @Autowired
    EmailService emailService;

    private String emailSubject;
    private String emailBody;

    public void sendEmail(String email, String subject, String body){
        this.emailBody = body;
        this.emailSubject = subject;

        emailService.sendEmail(email,
                emailSubject,
                emailBody);
    }
}
