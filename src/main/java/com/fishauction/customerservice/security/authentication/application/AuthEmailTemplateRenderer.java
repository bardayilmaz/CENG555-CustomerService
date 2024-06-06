package com.fishauction.customerservice.security.authentication.application;


import com.fishauction.customerservice.security.authentication.config.MailConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
@AllArgsConstructor
public class AuthEmailTemplateRenderer {

    private final TemplateEngine templateEngine;
    private final MailConfig mailConfig;

    public String renderSignInEmail(String email, String otp) {
        Context context = new Context();
        context.setVariable("host", mailConfig.getHost());
        context.setVariable("email", email);
        context.setVariable("otp", otp);
        return templateEngine.process("emails/sign-in", context);
    }

}