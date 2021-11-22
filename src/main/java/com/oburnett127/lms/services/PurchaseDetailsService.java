package com.oburnett127.bankmongo.services;

import com.oburnett127.bankmongo.daos.PurchaseDetailsDao;
import com.oburnett127.bankmongo.models.PurchaseDetails;
import com.oburnett127.bankmongo.utils.PurchaseDetailsValidator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PurchaseDetailsService implements PurchaseDetailsOperations {

	private final PurchaseDetailsDao PurchaseDetailsDao;
	private final PurchaseDetailsValidator PurchaseDetailsValidator;

	public PurchaseDetailsService(final PurchaseDetailsDao PurchaseDetailsDao, final PurchaseDetailsValidator PurchaseDetailsValidator) {
		this.PurchaseDetailsDao = PurchaseDetailsDao;
		this.PurchaseDetailsValidator = PurchaseDetailsValidator;
	}

	@Override
	public List<PurchaseDetails> listAll() {
		return this.PurchaseDetailsDao.getAll();
	}

	@Override
	public void createPurchaseDetails(PurchaseDetails PurchaseDetails) {
		this.PurchaseDetailsDao.create(PurchaseDetails);
	}

	@Override
	@SneakyThrows
	public PurchaseDetails getPurchaseDetails(final UUID id) {
		final var PurchaseDetails = PurchaseDetailsDao.getPurchaseDetails(id);

		return PurchaseDetails;
	}

	@Override
	@SneakyThrows
	public PurchaseDetails withdraw(UUID id, BigDecimal amount) {
		final var PurchaseDetails = PurchaseDetailsDao.getPurchaseDetails(id);

		PurchaseDetailsValidator.withdraw(PurchaseDetails, amount);

		PurchaseDetails.setBalance(PurchaseDetails.getBalance().subtract(amount));

		PurchaseDetailsDao.save(PurchaseDetails);

		return PurchaseDetails;
	}

	@Override
	@SneakyThrows
	public PurchaseDetails deposit(UUID id, BigDecimal amount) {
		final var PurchaseDetails = PurchaseDetailsDao.getPurchaseDetails(id);

		PurchaseDetailsValidator.deposit(id, amount);

		log.debug("PurchaseDetails.getId() {}", PurchaseDetails.getId());
		log.debug("PurchaseDetails balance: {} amount: {}", PurchaseDetails.getBalance(), amount);

		PurchaseDetails.setBalance(PurchaseDetails.getBalance().add(amount));

		PurchaseDetailsDao.save(PurchaseDetails);

		return PurchaseDetails;
	}

	@Override
	@SneakyThrows
	public PurchaseDetails depositCheck(UUID id, String fullName, String signature, BigDecimal amount) {
		final var PurchaseDetails = PurchaseDetailsDao.getPurchaseDetails(id);

		PurchaseDetailsValidator.depositCheck(id, fullName, signature, amount);

		PurchaseDetails.setBalance(PurchaseDetails.getBalance().add(amount));

		PurchaseDetailsDao.save(PurchaseDetails);

		return PurchaseDetails;
	}

	@Override
	@SneakyThrows
	public PurchaseDetails transfer(UUID idSender, UUID idReceiver, BigDecimal amount) {
		final var senderPurchaseDetails = PurchaseDetailsDao.getPurchaseDetails(idSender);
		final var receiverPurchaseDetails = PurchaseDetailsDao.getPurchaseDetails(idReceiver);

		PurchaseDetailsValidator.transfer(senderPurchaseDetails, receiverPurchaseDetails, amount);

		senderPurchaseDetails.setBalance(senderPurchaseDetails.getBalance().subtract(amount));
		receiverPurchaseDetails.setBalance(receiverPurchaseDetails.getBalance().add(amount));

		PurchaseDetailsDao.save(senderPurchaseDetails);
		PurchaseDetailsDao.save(receiverPurchaseDetails);

		return senderPurchaseDetails;
	}
}