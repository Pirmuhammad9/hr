package com.example.lesson5task.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailSender {
    @Autowired
    JavaMailSender javaMailSender;

    public boolean send(String to, String text) throws MessagingException {
        String from = "xusanov@gmail.com";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setSubject("Information");
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setText(text);
        mimeMessageHelper.setTo(to);
        javaMailSender.send(mimeMessage);
        return true;
    }

    public boolean mailTextAddStuff(String email, String code, String pass) throws MessagingException {
        String link = "<a href='http://localhost:8087/api/user/verifyEmail?email=" + email + "&code" + code + "'>Confirm</a>";

        String text = "";

        return send(email, text);
    }
}
