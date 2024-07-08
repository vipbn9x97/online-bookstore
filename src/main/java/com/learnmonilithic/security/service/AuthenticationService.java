package com.learnmonilithic.security.service;


import com.learnmonilithic.security.model.AuthenticationRequest;
import com.learnmonilithic.security.model.AuthenticationResponse;
import com.learnmonilithic.security.model.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);

    ResponseEntity<?> confirmEmail(String confirmationToken);
}
