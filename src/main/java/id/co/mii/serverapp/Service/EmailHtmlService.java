package id.co.mii.serverapp.Service;

import java.io.File;
// import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
// import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import id.co.mii.serverapp.Model.DTORequest.EmailRequest;
// import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailHtmlService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    public void sendHtmlMessage(EmailRequest emailRequest) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        Context context = new Context();
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", emailRequest.getName());
        variables.put("myname", emailRequest.getMyname());
        context.setVariables(variables);
        helper.setTo(emailRequest.getTo());
        helper.setSubject(emailRequest.getSubject());
        String html = templateEngine.process(emailRequest.getText(), context);
        helper.setText(html, true);
        FileSystemResource file = new FileSystemResource(
                new File(emailRequest.getAttach()));

        helper.addAttachment(file.getFilename(), file);
        javaMailSender.send(message);

        System.out.println();
        System.out.println("Email success to send...");
    }


}