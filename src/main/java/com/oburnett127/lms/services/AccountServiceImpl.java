package com.oburnett127.lms.services;

import com.oburnett127.lms.exceptions.ResourceNotFoundException;
import com.oburnett127.lms.models.Account;
import com.oburnett127.lms.models.dto.AccountDto;
import com.oburnett127.lms.repositories.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

//	private final AccountDao accountDao;
//	private final AccountValidator accountValidator;
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AccountDto create(AccountDto accountDto) {
		Account account = convertDtoToEntity(accountDto);
		Account createdAccount = accountRepository.save(account);
		return convertEntityToDto(createdAccount);
	}

	private AccountDto convertEntityToDto(Account account) {
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(account, AccountDto.class);
	}

	private Account convertDtoToEntity(AccountDto accountDto) {
		return modelMapper.map(accountDto, Account.class);
	}

	@Override
	public List<AccountDto> getAll() {
		return accountRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public AccountDto getAccount(UUID id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found."));
		return convertEntityToDto(account);
	}

	@Override
	public AccountDto update(AccountDto accountDto) {
		return null;
	}

	@Override
	public void delete(UUID id) {
		accountRepository.deleteById(id);
	}
//
//	public AccountServiceImpl(final AccountDao accountDao, final AccountValidator accountValidator) {
//		this.accountDao = accountDao;
//		this.accountValidator = accountValidator;
//	}
//
//	@Override
//	public List<Account> listAll() {
//		return this.accountDao.getAll();
//	}
//
//	@Override
//	public void createAccount(Account account) {
//		this.accountDao.create(account);
//	}
//
//	@Override
//	@SneakyThrows
//	public Account getAccount(final UUID id) {
//		final var account = accountDao.getAccount(id);
//
//		return account;
//	}
//
//	@Override
//	public Account updateAccount(Account Account) {
//		return null;
//	}
//
//	@Override
//	public void deleteAccount(Integer id) {
//
//	}
//
//	@Override
//	@SneakyThrows
//	public Account withdraw(UUID id, BigDecimal amount) {
//		final var account = accountDao.getAccount(id);
//
//		accountValidator.withdraw(account, amount);
//
//		account.setBalance(account.getBalance().subtract(amount));
//
//		accountDao.save(account);
//
//		return account;
//	}
//
//	@Override
//	@SneakyThrows
//	public Account deposit(UUID id, BigDecimal amount) {
//		final var account = accountDao.getAccount(id);
//
//		accountValidator.deposit(id, amount);
//
//		log.debug("account.getId() {}", account.getId());
//		log.debug("account balance: {} amount: {}", account.getBalance(), amount);
//
//		account.setBalance(account.getBalance().add(amount));
//
//		accountDao.save(account);
//
//		return account;
//	}
//
//	@Override
//	@SneakyThrows
//	public Account depositCheck(UUID id, String fullName, String signature, BigDecimal amount) {
//		final var account = accountDao.getAccount(id);
//
//		accountValidator.depositCheck(id, fullName, signature, amount);
//
//		account.setBalance(account.getBalance().add(amount));
//
//		accountDao.save(account);
//
//		return account;
//	}
//
//	@Override
//	@SneakyThrows
//	public Account transfer(UUID idSender, UUID idReceiver, BigDecimal amount) {
//		final var senderAccount = accountDao.getAccount(idSender);
//		final var receiverAccount = accountDao.getAccount(idReceiver);
//
//		accountValidator.transfer(senderAccount, receiverAccount, amount);
//
//		senderAccount.setBalance(senderAccount.getBalance().subtract(amount));
//		receiverAccount.setBalance(receiverAccount.getBalance().add(amount));
//
//		accountDao.save(senderAccount);
//		accountDao.save(receiverAccount);
//
//		return senderAccount;
//	}
}