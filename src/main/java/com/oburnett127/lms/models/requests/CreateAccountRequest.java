package com.oburnett127.lms.models.requests;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountRequest {
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String password;
    private boolean isAdmin;
    private boolean isAuthor;
}
