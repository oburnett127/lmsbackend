package com.oburnett127.lms.utils;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceError {
	private int code;
	private String message;
}
