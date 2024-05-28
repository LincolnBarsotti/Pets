package br.com.petspot.service.email;

import br.com.petspot.model.dto.logindto.FormsContactDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class SendEmail {

    @Autowired
    private JavaMailSender mailSender;


    @Async
    public void sendRequestNewPasswordEmail(String to){
        MimeMessage message = mailSender.createMimeMessage();

        try {
            message.setRecipients(MimeMessage.RecipientType.TO, to);
            message.setSubject("Solicitação de troca de senha");
            message.setContent(getRequestNewPasswordBodyMessage(), "text/html; charset=utf-8");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        mailSender.send(message);
    }

    @Async
    public void sendRegisterEmail(String to, String nameUser){
        MimeMessage message = mailSender.createMimeMessage();

        try {
            message.setRecipients(MimeMessage.RecipientType.TO, to);
            message.setSubject("Bem-vindo ao PetSpot");
            message.setContent(getRegisterBodyMessage().replace("${nameUser}", nameUser), "text/html; charset=utf-8");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        mailSender.send(message);
    }

    @Async
    public void sendLoginEmail(String to, String nameUser){
        MimeMessage message = mailSender.createMimeMessage();

        try {
            message.setRecipients(MimeMessage.RecipientType.TO, to);
            message.setSubject("Aviso de Login");
            message.setContent(getLoginBodyMessage().replace("${nameUser}", nameUser), "text/html; charset=utf-8");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        mailSender.send(message);
    }


    public void contactUs(FormsContactDto formsContactDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(formsContactDto.email());
            message.setTo("contatodl2b@gmail.com");

            message.setSubject(formsContactDto.subject());
            message.setText(formsContactDto.getNameAndBody());

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getRegisterBodyMessage() {
        try {
            return Files.readString(Paths.get("src/main/resources/template/RegisterMail.html"), StandardCharsets.UTF_8);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private String getLoginBodyMessage() {
        try {
            return Files.readString(Paths.get("src/main/resources/template/LoginMail.html"), StandardCharsets.UTF_8);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private String getRequestNewPasswordBodyMessage() {
        try {
            return Files.readString(Paths.get("src/main/resources/template/RequestNewPassword.html"), StandardCharsets.UTF_8);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }



}
