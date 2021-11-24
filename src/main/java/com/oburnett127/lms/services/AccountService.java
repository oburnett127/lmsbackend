package com.oburnett127.lms.services;

import com.oburnett127.lms.models.Account;
import com.oburnett127.lms.models.dto.AccountDto;

import java.util.List;
import java.util.UUID;

public interface AccountService {

	AccountDto create(AccountDto accountDto);
	
	List<AccountDto> getAll();
	
	AccountDto getAccount(UUID id);

	AccountDto update(AccountDto accountDto);

	void delete(UUID id);

}