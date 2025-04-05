package com.example.hubspot.dto;

import lombok.Data;

@Data
public class ContactDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String company;
}