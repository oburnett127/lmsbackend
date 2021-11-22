package com.oburnett127.lms.controllers;

import com.oburnett127.lms.models.Purchase;
import com.oburnett127.lms.services.PurchaseOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@Slf4j
public class PurchaseController {

	private final PurchaseOperations service;

	public PurchaseController(final PurchaseOperations service){
		this.service = service;
	}

	@GetMapping("/view")
	public ResponseEntity<List<Purchase>> view() {
		final var result = service.listAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/Purchase")
	public ResponseEntity<Purchase> getPurchase(@Validated @RequestBody PurchaseRequest PurchaseRequest) {
		final var Purchase = service.getPurchase(PurchaseRequest.getId());
		return ResponseEntity.ok().body(Purchase);
	}


	@PostMapping("/create")
	public ResponseEntity<Purchase> createPurchase(@Validated @RequestBody CreatePurchaseRequest createPurchaseRequest) throws IOException {
		final var Purchase = Purchase.builder()
				.email(createPurchaseRequest.getEmail())
				.phone(createPurchaseRequest.getPhone())
				.firstName(createPurchaseRequest.getFirstName())
				.lastName(createPurchaseRequest.getLastName())
				.password(createPurchaseRequest.getPassword())
				.is_admin(createPurchaseRequest.isAdmin())
				.build();
		service.createPurchase(Purchase);
		log.debug(DebugMessage.MSG5,Purchase.getFullName(),Purchase.getId());


		return ResponseEntity.ok(Purchase);
	}

	@PostMapping("/update)
			public ResponseEntity<Purchase> updatePurchase(@Validated @RequestBody UpdatePurchaseRequest updatePurchaseRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/delete)
			public ResponseEntity<Purchase> deletePurchase(@Validated @RequestBody DeletePurchaseRequest updatePurchaseRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}
}