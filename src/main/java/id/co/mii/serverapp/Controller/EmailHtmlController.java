package id.co.mii.serverapp.Controller;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.mii.serverapp.Model.DTORequest.EmailRequest;
import id.co.mii.serverapp.Service.EmailHtmlService;
import lombok.AllArgsConstructor;

@RestController
// @RequestMapping("/email")
@AllArgsConstructor
public class EmailHtmlController {
    private EmailHtmlService emailHtmlService;

    @PostMapping("/email/send/html")
    public void sendHtmlMessage( @RequestBody EmailRequest emailRequest) throws MessagingException {
        
        emailHtmlService.sendHtmlMessage(emailRequest);
    }

}
