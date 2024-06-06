package com.fishauction.customerservice.security.authentication.application;

import com.fishauction.customerservice.common.application.EmailService;
import com.fishauction.customerservice.customer.domain.model.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class AuthEmailService {

    private final AuthEmailTemplateRenderer authEmailTemplateRenderer;
    private final EmailService emailService;

    public void sendSignInEmail(Customer user, String otp) {
        CompletableFuture.runAsync(() -> {
            String recipientAddress = user.getEmail();
            String subject = "Template | OTP Code";
            String html = authEmailTemplateRenderer.renderSignInEmail(user.getEmail(), otp);
            emailService.sendEmail(recipientAddress, subject, html);
        });
    }
}
