package com.fishauction.customerservice.common.application;

import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendEmail(String recipientAddress, String subject, String html) {
        log.info("Sending email, recipientAddress: {}", recipientAddress);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(recipientAddress);
            helper.setSubject(subject);
            helper.setText(html, true);

            javaMailSender.send(mimeMessage);
            log.info("Email sent! recipientAddress: {}", recipientAddress);
        } catch (Exception e) {
            log.error("Error sending email", e);
        }
    }
}
