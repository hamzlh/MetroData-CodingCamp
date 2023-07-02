package id.co.mii.serverapp.Service;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import id.co.mii.serverapp.Model.DTORequest.EmailRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {


    private JavaMailSender javaMailSender;
    private SpringTemplateEngine templateEngine;

    public EmailRequest sendSimpleMessage(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getText());
        javaMailSender.send(message);
        return emailRequest;
    }

    public EmailRequest sendMessageWithAttachment(EmailRequest emailRequest) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getAttach());

            FileSystemResource file = new FileSystemResource(new File(emailRequest.getAttach()));
            helper.addAttachment(file.getFilename(), file);

            javaMailSender.send(message);

            System.out.println("\nSuccess to send email.\n");
        } catch (Exception e) {
            throw new IllegalStateException("Failed to send email.");

        }
        return emailRequest;
    }

    public EmailRequest tryThymeleafEmail(EmailRequest emailRequest) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());
            Context context = new Context();
            // context.setVariables(emailRequest.getProperties());
            // helper.setFrom(emailRequest.getFrom());
            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());
            String html = templateEngine.process("welcome-email.html", context);
            helper.setText(html, true);

            // log.info("Sending email: {} with html body: {}", emailRequest, html);
            javaMailSender.send(message);

            System.out.println("\nSuccess to send email.\n");
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to send email.");
        }
        return emailRequest;
    }

    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
