package com.fishauction.customerservice.security.authentication.application;

import com.fishauction.customerservice.customer.domain.model.entity.Customer;
import com.fishauction.customerservice.customer.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationFacade {

    private final CustomerRepository userRepository;

    public Customer getUserThroughAuthentication(Authentication auth) {
        UserDetails user = (UserDetails) auth.getPrincipal();
        return userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
