package com.oburnett127.bankmongo.services;

import com.oburnett127.bankmongo.daos.PurchaseDao;
import com.oburnett127.bankmongo.models.Purchase;
import com.oburnett127.bankmongo.utils.PurchaseValidator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PurchaseService implements PurchaseOperations {

	private final PurchaseDao PurchaseDao;
	private final PurchaseValidator PurchaseValidator;

	public PurchaseService(final PurchaseDao PurchaseDao, final PurchaseValidator PurchaseValidator) {
		this.PurchaseDao = PurchaseDao;
		this.PurchaseValidator = PurchaseValidator;
	}

	@Override
	public List<Purchase> listAll() {
		return this.PurchaseDao.getAll();
	}

	@Override
	public void createPurchase(Purchase Purchase) {
		this.PurchaseDao.create(Purchase);
	}

	@Override
	@SneakyThrows
	public Purchase getPurchase(final UUID id) {
		final var Purchase = PurchaseDao.getPurchase(id);

		return Purchase;
	}

	@Override
	@SneakyThrows
	public Purchase withdraw(UUID id, BigDecimal amount) {
		final var Purchase = PurchaseDao.getPurchase(id);

		PurchaseValidator.withdraw(Purchase, amount);

		Purchase.setBalance(Purchase.getBalance().subtract(amount));

		PurchaseDao.save(Purchase);

		return Purchase;
	}

	@Override
	@SneakyThrows
	public Purchase deposit(UUID id, BigDecimal amount) {
		final var Purchase = PurchaseDao.getPurchase(id);

		PurchaseValidator.deposit(id, amount);

		log.debug("Purchase.getId() {}", Purchase.getId());
		log.debug("Purchase balance: {} amount: {}", Purchase.getBalance(), amount);

		Purchase.setBalance(Purchase.getBalance().add(amount));

		PurchaseDao.save(Purchase);

		return Purchase;
	}

	@Override
	@SneakyThrows
	public Purchase depositCheck(UUID id, String fullName, String signature, BigDecimal amount) {
		final var Purchase = PurchaseDao.getPurchase(id);

		PurchaseValidator.depositCheck(id, fullName, signature, amount);

		Purchase.setBalance(Purchase.getBalance().add(amount));

		PurchaseDao.save(Purchase);

		return Purchase;
	}

	@Override
	@SneakyThrows
	public Purchase transfer(UUID idSender, UUID idReceiver, BigDecimal amount) {
		final var senderPurchase = PurchaseDao.getPurchase(idSender);
		final var receiverPurchase = PurchaseDao.getPurchase(idReceiver);

		PurchaseValidator.transfer(senderPurchase, receiverPurchase, amount);

		senderPurchase.setBalance(senderPurchase.getBalance().subtract(amount));
		receiverPurchase.setBalance(receiverPurchase.getBalance().add(amount));

		PurchaseDao.save(senderPurchase);
		PurchaseDao.save(receiverPurchase);

		return senderPurchase;
	}
}