package com.oburnett127.lms.models.requests;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteAccountRequest {
   private UUID id;
}
