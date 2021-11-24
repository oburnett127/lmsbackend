package com.oburnett127.lms.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private UUID id;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String password;
    private boolean isAdmin;
    private boolean isAuthor;
}
