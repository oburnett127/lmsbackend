package com.oburnett127.lms.controllers;

import com.oburnett127.lms.models.Product;
import com.oburnett127.lms.services.ProductOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@Slf4j
public class ProductController {

	private final ProductOperations service;

	public ProductController(final ProductOperations service){
		this.service = service;
	}

	@GetMapping("/view")
	public ResponseEntity<List<Product>> view() {
		final var result = service.listAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/Product")
	public ResponseEntity<Product> getProduct(@Validated @RequestBody ProductRequest ProductRequest) {
		final var Product = service.getProduct(ProductRequest.getId());
		return ResponseEntity.ok().body(Product);
	}


	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@Validated @RequestBody CreateProductRequest createProductRequest) throws IOException {
		final var Product = Product.builder()
				.email(createProductRequest.getEmail())
				.phone(createProductRequest.getPhone())
				.firstName(createProductRequest.getFirstName())
				.lastName(createProductRequest.getLastName())
				.password(createProductRequest.getPassword())
				.is_admin(createProductRequest.isAdmin())
				.build();
		service.createProduct(Product);
		log.debug(DebugMessage.MSG5,Product.getFullName(),Product.getId());


		return ResponseEntity.ok(Product);
	}

	@PostMapping("/update")
			public ResponseEntity<Product> updateProduct(@Validated @RequestBody UpdateProductRequest updateProductRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/delete")
	public ResponseEntity<Product> deleteProduct(@Validated @RequestBody DeleteProductRequest updateProductRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}
}