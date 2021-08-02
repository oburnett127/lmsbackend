package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Account;
import com.oburnett127.MyEcomm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements com.oburnett127.MyEcomm.service.AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account createAccount(Account account) {
		return accountRepository.createAccount(account);
	}
	
	@Override
	public Account getAccount(Integer id) {
		return accountRepository.getAccount(id);
	}
	
	@Override
	public List<Account> getAccounts() {
		return accountRepository.getAccounts();
	}
	
	@Override
	public Account updateAccount(Account account) {
		return accountRepository.updateAccount(account);
	}
	
	@Override
	public void deleteAccount(Integer id) {
		accountRepository.deleteAccount(id);
	}
}