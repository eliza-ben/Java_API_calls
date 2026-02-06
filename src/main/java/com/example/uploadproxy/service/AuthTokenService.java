package com.example.uploadproxy.service;

import com.example.uploadproxy.dto.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AuthTokenService {

  private final WebClient webClient;
  private final String tokenPath;

  public AuthTokenService(
      WebClient.Builder builder,
      @Value("${auth.base-url}") String baseUrl,
      @Value("${auth.token-path:/oauth/token}") String tokenPath
  ) {
    this.webClient = builder.baseUrl(baseUrl).build();
    this.tokenPath = tokenPath;
  }

  public TokenResponse passwordGrant(String clientId, String clientSecret, String username, String password) {
    MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
    form.add("grant_type", "password");
    form.add("client_id", clientId);
    form.add("client_secret", clientSecret);
    form.add("username", username);
    form.add("password", password);

    return webClient.post()
        .uri(tokenPath)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(form)
        .retrieve()
        .bodyToMono(TokenResponse.class)
        .block();
  }
}
