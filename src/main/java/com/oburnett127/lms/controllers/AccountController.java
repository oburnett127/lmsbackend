package com.oburnett127.lms.controllers;

import com.oburnett127.lms.constants.DebugMessage;
import com.oburnett127.lms.models.Account;
import com.oburnett127.lms.models.dto.AccountDto;
import com.oburnett127.lms.models.requests.AccountRequest;
import com.oburnett127.lms.models.requests.CreateAccountRequest;
import com.oburnett127.lms.models.requests.DeleteAccountRequest;
import com.oburnett127.lms.models.requests.UpdateAccountRequest;
import com.oburnett127.lms.services.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/account")
public class AccountController {

	private final AccountService accountService;

	public AccountController(final AccountService accountService){
		this.accountService = accountService;
	}

	@GetMapping()
	public List<AccountDto> all() {
		return accountService.getAll();
	}

	@GetMapping("/{id}")
	public AccountDto getAccount(@PathVariable UUID id) {
		return accountService.getAccount(id);
	}


	@PostMapping("/create")
	public AccountDto create(@Validated @RequestBody AccountDto accountDto) {
		return accountService.create(accountDto);
	}

//	@PostMapping("/update")
//	public ResponseEntity<Account> updateAccount(@Validated @RequestBody UpdateAccountRequest updateAccountRequest) throws IOException {
//		final var id = updateAccountRequest.getId();
//		final var amount = updateAccountRequest.getAmount();
//		final var result = service.updateAccount(id, amount);
//		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
//		return ResponseEntity.ok().body(result);
//	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable UUID id) {
		accountService.delete(id);
	}
}