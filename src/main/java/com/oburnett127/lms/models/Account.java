package com.oburnett127.lms.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table
@Entity
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