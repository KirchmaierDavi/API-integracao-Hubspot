package com.example.hubspot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class WebhookService {

    public void processContactCreationWebhook(@RequestBody String webhookPayload) {
     
    }
}