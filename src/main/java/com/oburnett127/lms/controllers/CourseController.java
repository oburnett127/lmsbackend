package com.oburnett127.lms.controllers;

import com.oburnett127.lms.models.Account;
import com.oburnett127.lms.services.AccountOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@Slf4j
public class CourseController {

	private final AccountOperations service;

	public CourseController(final AccountOperations service){
		this.service = service;
	}

	@GetMapping("/view")
	public ResponseEntity<List<Account>> view() {
		final var result = service.listAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/account")
	public ResponseEntity<Account> getAccount(@Validated @RequestBody AccountRequest accountRequest) {
		final var account = service.getAccount(accountRequest.getId());
		return ResponseEntity.ok().body(account);
	}


	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@Validated @RequestBody CreateAccountRequest createAccountRequest) throws IOException {
		final var account = Account.builder()
				.email(createAccountRequest.getEmail())
				.phone(createAccountRequest.getPhone())
				.firstName(createAccountRequest.getFirstName())
				.lastName(createAccountRequest.getLastName())
				.password(createAccountRequest.getPassword())
				.is_admin(createAccountRequest.isAdmin())
				.build();
		service.createAccount(account);
		log.debug(DebugMessage.MSG5,account.getFullName(),account.getId());


		return ResponseEntity.ok(account);
	}

	@PostMapping("/update)
	public ResponseEntity<Account> updateAccount(@Validated @RequestBody UpdateAccountRequest updateAccountRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/delete)
			public ResponseEntity<Account> deleteAccount(@Validated @RequestBody DeleteAccountRequest updateAccountRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}
}