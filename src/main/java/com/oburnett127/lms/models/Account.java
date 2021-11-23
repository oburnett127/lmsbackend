package com.oburnett127.lms.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
	@Id
	private UUID id;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="password")
	private String password;
	@Column(name="is_admin")
	private boolean isAdmin;
	@Column(name="is_author")
	private boolean isAuthor;
}