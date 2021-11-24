package com.oburnett127.lms.models.requests;

import lombok.Data;

@Data
public class UpdateAccountRequest {
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String password;
    private boolean isAdmin;
    private boolean isAuthor;
}
