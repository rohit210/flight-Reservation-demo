package com.rohit.flightreservation.Utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmilUtil {
    @Value("${com.rohit.flightreservation.itinarary.email.body}")
    public  String EMAIL_BODY ;
    @Value("${com.rohit.flightreservation.itinarary.email.subject}")
    public  String EMAIL_SUBJECT ;
    @Autowired
    private JavaMailSender sender;

    public void sendItinanry(String toAddress, String filePath) {

        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject(EMAIL_SUBJECT);
            messageHelper.setText(EMAIL_BODY);
            messageHelper.addAttachment("itinanry", new File(filePath));
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
