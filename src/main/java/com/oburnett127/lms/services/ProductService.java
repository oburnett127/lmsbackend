package com.oburnett127.bankmongo.services;

import com.oburnett127.bankmongo.daos.ProductDao;
import com.oburnett127.bankmongo.models.Product;
import com.oburnett127.bankmongo.utils.ProductValidator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ProductService implements ProductOperations {

	private final ProductDao ProductDao;
	private final ProductValidator ProductValidator;

	public ProductService(final ProductDao ProductDao, final ProductValidator ProductValidator) {
		this.ProductDao = ProductDao;
		this.ProductValidator = ProductValidator;
	}

	@Override
	public List<Product> listAll() {
		return this.ProductDao.getAll();
	}

	@Override
	public void createProduct(Product Product) {
		this.ProductDao.create(Product);
	}

	@Override
	@SneakyThrows
	public Product getProduct(final UUID id) {
		final var Product = ProductDao.getProduct(id);

		return Product;
	}

	@Override
	@SneakyThrows
	public Product withdraw(UUID id, BigDecimal amount) {
		final var Product = ProductDao.getProduct(id);

		ProductValidator.withdraw(Product, amount);

		Product.setBalance(Product.getBalance().subtract(amount));

		ProductDao.save(Product);

		return Product;
	}

	@Override
	@SneakyThrows
	public Product deposit(UUID id, BigDecimal amount) {
		final var Product = ProductDao.getProduct(id);

		ProductValidator.deposit(id, amount);

		log.debug("Product.getId() {}", Product.getId());
		log.debug("Product balance: {} amount: {}", Product.getBalance(), amount);

		Product.setBalance(Product.getBalance().add(amount));

		ProductDao.save(Product);

		return Product;
	}

	@Override
	@SneakyThrows
	public Product depositCheck(UUID id, String fullName, String signature, BigDecimal amount) {
		final var Product = ProductDao.getProduct(id);

		ProductValidator.depositCheck(id, fullName, signature, amount);

		Product.setBalance(Product.getBalance().add(amount));

		ProductDao.save(Product);

		return Product;
	}

	@Override
	@SneakyThrows
	public Product transfer(UUID idSender, UUID idReceiver, BigDecimal amount) {
		final var senderProduct = ProductDao.getProduct(idSender);
		final var receiverProduct = ProductDao.getProduct(idReceiver);

		ProductValidator.transfer(senderProduct, receiverProduct, amount);

		senderProduct.setBalance(senderProduct.getBalance().subtract(amount));
		receiverProduct.setBalance(receiverProduct.getBalance().add(amount));

		ProductDao.save(senderProduct);
		ProductDao.save(receiverProduct);

		return senderProduct;
	}
}