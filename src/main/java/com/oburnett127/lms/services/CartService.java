package com.oburnett127.lms.services;

import com.oburnett127.lms.daos.CartDao;
import com.oburnett127.lms.models.Cart;
import com.oburnett127.lms.utils.CartValidator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CartService implements CartOperations {

	private final CartDao CartDao;
	private final CartValidator CartValidator;

	public CartService(final CartDao CartDao, final CartValidator CartValidator) {
		this.CartDao = CartDao;
		this.CartValidator = CartValidator;
	}

	@Override
	public List<Cart> listAll() {
		return this.CartDao.getAll();
	}

	@Override
	public void createCart(Cart Cart) {
		this.CartDao.create(Cart);
	}

	@Override
	@SneakyThrows
	public Cart getCart(final UUID id) {
		final var Cart = CartDao.getCart(id);

		return Cart;
	}

	@Override
	@SneakyThrows
	public Cart withdraw(UUID id, BigDecimal amount) {
		final var Cart = CartDao.getCart(id);

		CartValidator.withdraw(Cart, amount);

		Cart.setBalance(Cart.getBalance().subtract(amount));

		CartDao.save(Cart);

		return Cart;
	}

	@Override
	@SneakyThrows
	public Cart deposit(UUID id, BigDecimal amount) {
		final var Cart = CartDao.getCart(id);

		CartValidator.deposit(id, amount);

		log.debug("Cart.getId() {}", Cart.getId());
		log.debug("Cart balance: {} amount: {}", Cart.getBalance(), amount);

		Cart.setBalance(Cart.getBalance().add(amount));

		CartDao.save(Cart);

		return Cart;
	}

	@Override
	@SneakyThrows
	public Cart depositCheck(UUID id, String fullName, String signature, BigDecimal amount) {
		final var Cart = CartDao.getCart(id);

		CartValidator.depositCheck(id, fullName, signature, amount);

		Cart.setBalance(Cart.getBalance().add(amount));

		CartDao.save(Cart);

		return Cart;
	}

	@Override
	@SneakyThrows
	public Cart transfer(UUID idSender, UUID idReceiver, BigDecimal amount) {
		final var senderCart = CartDao.getCart(idSender);
		final var receiverCart = CartDao.getCart(idReceiver);

		CartValidator.transfer(senderCart, receiverCart, amount);

		senderCart.setBalance(senderCart.getBalance().subtract(amount));
		receiverCart.setBalance(receiverCart.getBalance().add(amount));

		CartDao.save(senderCart);
		CartDao.save(receiverCart);

		return senderCart;
	}
}