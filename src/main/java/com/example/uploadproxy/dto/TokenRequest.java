package com.example.uploadproxy.dto;

import jakarta.validation.constraints.NotBlank;

public class TokenRequest {
  @NotBlank public String clientId;
  @NotBlank public String clientSecret;
  @NotBlank public String username;
  @NotBlank public String password;
}
