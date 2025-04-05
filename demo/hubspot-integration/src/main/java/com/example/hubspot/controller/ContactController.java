package com.example.hubspot.controller;

import com.example.hubspot.dto.ContactDTO;
import com.example.hubspot.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<String> createContact(@RequestBody ContactDTO contactDTO) {
        contactService.createContact(contactDTO);
        return ResponseEntity.ok("Contact created successfully");
    }
}