package com.example.hubspot.controller;

import com.example.hubspot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final String CLIENT_ID = "your-client-id";
    private static final String CLIENT_SECRET = "your-client-secret"; 
    private static final String REDIRECT_URI = "http://localhost:8080/auth/callback";
    private static final String SCOPE = "contacts";

    @GetMapping("/url")
    public ResponseEntity<String> getAuthUrl() {
        String authUrl = String.format(
            "https://app.hubspot.com/oauth/authorize" +
            "?client_id=%s" +
            "&redirect_uri=%s" +
            "&scope=%s",
            CLIENT_ID,
            REDIRECT_URI, 
            SCOPE
        );
        return ResponseEntity.ok(authUrl);
    }

    @GetMapping("/callback")
    public ResponseEntity<String> handleCallback(@RequestParam String code) {
        // Exchange code for access token
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("client_id", CLIENT_ID);
        map.add("client_secret", CLIENT_SECRET);
        map.add("redirect_uri", REDIRECT_URI);
        map.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(
            "https://api.hubapi.com/oauth/v1/token",
            request,
            TokenResponse.class
        );

        return ResponseEntity.ok("Token obtained successfully!");
    }
}