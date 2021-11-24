//package com.oburnett127.lms.controllers;
//
//import com.oburnett127.lms.constants.DebugMessage;
//import com.oburnett127.lms.models.Account;
//import com.oburnett127.lms.models.requests.AccountRequest;
//import com.oburnett127.lms.models.requests.CreateAccountRequest;
//import com.oburnett127.lms.models.requests.DeleteAccountRequest;
//import com.oburnett127.lms.models.requests.UpdateAccountRequest;
//import com.oburnett127.lms.services.AccountOperations;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import java.io.IOException;
//import java.util.List;
//
//
//@CrossOrigin
//@RestController
//@Slf4j
//public class AccountController {
//
//	private final AccountOperations service;
//
//	public AccountController(final AccountOperations service){
//		this.service = service;
//	}
//
//	@GetMapping("/view")
//	public ResponseEntity<List<Account>> view() {
//		final var result = service.listAll();
//		return ResponseEntity.ok().body(result);
//	}
//
//	@GetMapping("/account")
//	public ResponseEntity<Account> getAccount(@Validated @RequestBody AccountRequest accountRequest) {
//		final Account account = service.getAccount(accountRequest.getId());
//		return ResponseEntity.ok().body(account);
//	}
//
//
//	@PostMapping("/create")
//	public ResponseEntity<Account> createAccount(@Validated @RequestBody CreateAccountRequest createAccountRequest) throws IOException {
//		final var account = Account.builder()
//				.email(createAccountRequest.getEmail())
//				.phone(createAccountRequest.getPhone())
//				.firstName(createAccountRequest.getFirstName())
//				.lastName(createAccountRequest.getLastName())
//				.password(createAccountRequest.getPassword())
//				.isAdmin(createAccountRequest.isAdmin())
//				.isAuthor(createAccountRequest.isAuthor())
//				.build();
//		service.createAccount(account);
//		log.debug(DebugMessage.MSG5,account.getFirstName() + " " + account.getLastName(),account.getId());
//		return ResponseEntity.ok(account);
//	}
//
//	@PostMapping("/update")
//	public ResponseEntity<Account> updateAccount(@Validated @RequestBody UpdateAccountRequest updateAccountRequest) throws IOException {
//		final var id = updateAccountRequest.getId();
//		final var amount = updateAccountRequest.getAmount();
//		final var result = service.updateAccount(id, amount);
//		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
//		return ResponseEntity.ok().body(result);
//	}
//
//	@PostMapping("/delete")
//	public ResponseEntity<Account> deleteAccount(@Validated @RequestBody DeleteAccountRequest deleteAccountRequest) throws IOException {
//		final var id = deleteAccountRequest.getId();
//		final var amount = deleteAccountRequest.getAmount();
//		final var result = service.deleteAccount(id, amount);
//		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
//		return ResponseEntity.ok().body(result);
//	}
//}