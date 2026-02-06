package com.example.uploadproxy.controller;

import com.example.uploadproxy.dto.TokenRequest;
import com.example.uploadproxy.dto.TokenResponse;
import com.example.uploadproxy.service.AuthTokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthTokenService authTokenService;

  public AuthController(AuthTokenService authTokenService) {
    this.authTokenService = authTokenService;
  }

  @PostMapping("/token")
  public ResponseEntity<TokenResponse> token(@Valid @RequestBody TokenRequest req) {
    TokenResponse token = authTokenService.passwordGrant(
        req.clientId, req.clientSecret, req.username, req.password
    );
    return ResponseEntity.ok(token);
  }
}
