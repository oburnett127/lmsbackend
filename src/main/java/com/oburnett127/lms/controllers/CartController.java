package com.oburnett127.lms.controllers;

import com.oburnett127.MyEcomm.model.Cart;
import com.oburnett127.MyEcomm.service.CartService;
import com.oburnett127.MyEcomm.util.ServiceError;
import com.oburnett127.lms.models.Cart;
import com.oburnett127.lms.models.CartRequest;
import com.oburnett127.lms.models.CreateCartRequest;
import com.oburnett127.lms.services.CartOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@Slf4j
public class CartController {

	private final CartOperations service;

	public Cartontroller(final CartOperations service){
		this.service = service;
	}

	@GetMapping("/view")
	public ResponseEntity<List<Cart>> view() {
		final var result = service.listAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/Cart")
	public ResponseEntity<Cart> getCart(@Validated @RequestBody CartRequest CartRequest) {
		final var Cart = service.getCart(CartRequest.getId());
		return ResponseEntity.ok().body(Cart);
	}


	@PostMapping("/create")
	public ResponseEntity<Cart> createCart(@Validated @RequestBody CreateCartRequest createCartRequest) throws IOException {
		final var Cart = Cart.builder()
				.email(createCartRequest.getEmail())
				.phone(createCartRequest.getPhone())
				.firstName(createCartRequest.getFirstName())
				.lastName(createCartRequest.getLastName())
				.password(createCartRequest.getPassword())
				.is_admin(createCartRequest.isAdmin())
				.is_author(createCartRequest.isAuthor())
				.build();
		service.createCart(Cart);
		log.debug(DebugMessage.MSG5,Cart.getFullName(),Cart.getId());


		return ResponseEntity.ok(Cart);
	}

	@PostMapping("/update)
			public ResponseEntity<Cart> updateCart(@Validated @RequestBody UpdateCartRequest updateCartRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/delete)
			public ResponseEntity<Cart> deleteCart(@Validated @RequestBody DeleteCartRequest deleteCartRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}
}