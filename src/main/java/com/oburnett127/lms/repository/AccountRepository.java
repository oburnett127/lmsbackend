package com.oburnett127.lms.repository;

import com.oburnett127.MyEcomm.model.Account;

import java.util.List;

public interface AccountRepository {

	Account createAccount(Account account);
	
	List<Account> getAccounts();

	Account getAccount(Integer id);

	Account updateAccount(Account account);

	void deleteAccount(Integer id);
}