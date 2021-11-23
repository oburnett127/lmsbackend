//package com.oburnett127.lms.services;
//
//import com.oburnett127.lms.daos.RatingDao;
//import com.oburnett127.lms.models.Rating;
//import com.oburnett127.lms.utils.RatingValidator;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//@Slf4j
//public class RatingService implements RatingOperations {
//
//	private final RatingDao RatingDao;
//	private final RatingValidator RatingValidator;
//
//	public RatingService(final RatingDao RatingDao, final RatingValidator RatingValidator) {
//		this.RatingDao = RatingDao;
//		this.RatingValidator = RatingValidator;
//	}
//
//	@Override
//	public List<Rating> listAll() {
//		return this.RatingDao.getAll();
//	}
//
//	@Override
//	public void createRating(Rating Rating) {
//		this.RatingDao.create(Rating);
//	}
//
//	@Override
//	@SneakyThrows
//	public Rating getRating(final UUID id) {
//		final var Rating = RatingDao.getRating(id);
//
//		return Rating;
//	}
//
//	@Override
//	@SneakyThrows
//	public Rating withdraw(UUID id, BigDecimal amount) {
//		final var Rating = RatingDao.getRating(id);
//
//		RatingValidator.withdraw(Rating, amount);
//
//		Rating.setBalance(Rating.getBalance().subtract(amount));
//
//		RatingDao.save(Rating);
//
//		return Rating;
//	}
//
//	@Override
//	@SneakyThrows
//	public Rating deposit(UUID id, BigDecimal amount) {
//		final var Rating = RatingDao.getRating(id);
//
//		RatingValidator.deposit(id, amount);
//
//		log.debug("Rating.getId() {}", Rating.getId());
//		log.debug("Rating balance: {} amount: {}", Rating.getBalance(), amount);
//
//		Rating.setBalance(Rating.getBalance().add(amount));
//
//		RatingDao.save(Rating);
//
//		return Rating;
//	}
//
//	@Override
//	@SneakyThrows
//	public Rating depositCheck(UUID id, String fullName, String signature, BigDecimal amount) {
//		final var Rating = RatingDao.getRating(id);
//
//		RatingValidator.depositCheck(id, fullName, signature, amount);
//
//		Rating.setBalance(Rating.getBalance().add(amount));
//
//		RatingDao.save(Rating);
//
//		return Rating;
//	}
//
//	@Override
//	@SneakyThrows
//	public Rating transfer(UUID idSender, UUID idReceiver, BigDecimal amount) {
//		final var senderRating = RatingDao.getRating(idSender);
//		final var receiverRating = RatingDao.getRating(idReceiver);
//
//		RatingValidator.transfer(senderRating, receiverRating, amount);
//
//		senderRating.setBalance(senderRating.getBalance().subtract(amount));
//		receiverRating.setBalance(receiverRating.getBalance().add(amount));
//
//		RatingDao.save(senderRating);
//		RatingDao.save(receiverRating);
//
//		return senderRating;
//	}
//
//	@Override
//	public List<Rating> getRatings() {
//		return null;
//	}
//
//	@Override
//	public Rating getRating(Integer id) {
//		return null;
//	}
//
//	@Override
//	public void deleteRating(Integer id) {
//
//	}
//
//	@Override
//	public Rating updateRating(Rating Rating) {
//		return null;
//	}
//}