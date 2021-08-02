package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Account;

import java.util.List;

public interface AccountService {

	Account createAccount(Account Account);
	
	List<Account> getAccounts();
	
	Account getAccount(Integer id);

	Account updateAccount(Account Account);

	void deleteAccount(Integer id);

}