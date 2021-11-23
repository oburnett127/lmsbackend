package com.oburnett127.lms.services;

import com.oburnett127.lms.models.Account;
import java.util.List;
import java.util.UUID;

public interface AccountOperations {

	Account createAccount(Account Account);
	
	List<Account> listAll();
	
	Account getAccount(UUID id);

	Account updateAccount(Account Account);

	void deleteAccount(Integer id);

}