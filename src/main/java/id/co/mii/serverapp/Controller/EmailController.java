package id.co.mii.serverapp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.mii.serverapp.Model.DTORequest.EmailRequest;
import id.co.mii.serverapp.Service.EmailService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/mail")
public class EmailController {
    private EmailService emailService;

    @PostMapping("/simple")
    public EmailRequest sendSimpleMessage(@RequestBody EmailRequest emailRequest){
        return emailService.sendSimpleMessage(emailRequest);
    }

    @PostMapping("/attach")
    public EmailRequest sendMessageWithAttachment(@RequestBody EmailRequest emailRequest){
        return emailService.sendMessageWithAttachment(emailRequest);
    }
}
