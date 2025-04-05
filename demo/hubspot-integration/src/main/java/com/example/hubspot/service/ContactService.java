package com.example.hubspot.service;

import com.example.hubspot.dto.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContactService {

    private final RestTemplate restTemplate;

    @Autowired
    public ContactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createContact(ContactDTO contactDTO) {
        String url = "https://api.hubapi.com/contacts/v1/contact";
        restTemplate.postForEntity(url, contactDTO, Void.class);
    }
}