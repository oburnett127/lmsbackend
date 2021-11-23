//package com.oburnett127.lms.controllers;
//
//import com.oburnett127.lms.models.PurchaseDetails;
//import com.oburnett127.lms.services.PurchaseDetailsOperations;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.List;
//
//
//@CrossOrigin
//@RestController
//@Slf4j
//public class PurchaseDetailsController {
//
//	private final PurchaseDetailsOperations service;
//
//	public PurchaseDetailsController(final PurchaseDetailsOperations service){
//		this.service = service;
//	}
//
//	@GetMapping("/view")
//	public ResponseEntity<List<PurchaseDetails>> view() {
//		final var result = service.listAll();
//		return ResponseEntity.ok().body(result);
//	}
//
//	@GetMapping("/PurchaseDetails")
//	public ResponseEntity<PurchaseDetails> getPurchaseDetails(@Validated @RequestBody PurchaseDetailsRequest PurchaseDetailsRequest) {
//		final var PurchaseDetails = service.getPurchaseDetails(PurchaseDetailsRequest.getId());
//		return ResponseEntity.ok().body(PurchaseDetails);
//	}
//
//
//	@PostMapping("/create")
//	public ResponseEntity<PurchaseDetails> createPurchaseDetails(@Validated @RequestBody CreatePurchaseDetailsRequest createPurchaseDetailsRequest) throws IOException {
//		final var PurchaseDetails = PurchaseDetails.builder()
//				.email(createPurchaseDetailsRequest.getEmail())
//				.phone(createPurchaseDetailsRequest.getPhone())
//				.firstName(createPurchaseDetailsRequest.getFirstName())
//				.lastName(createPurchaseDetailsRequest.getLastName())
//				.password(createPurchaseDetailsRequest.getPassword())
//				.is_admin(createPurchaseDetailsRequest.isAdmin())
//				.build();
//		service.createPurchaseDetails(PurchaseDetails);
//		log.debug(DebugMessage.MSG5,PurchaseDetails.getFullName(),PurchaseDetails.getId());
//
//
//		return ResponseEntity.ok(PurchaseDetails);
//	}
//
//	@PostMapping("/update)
//			public ResponseEntity<PurchaseDetails> updatePurchaseDetails(@Validated @RequestBody UpdatePurchaseDetailsRequest updatePurchaseDetailsRequest) throws IOException {
//		final var id = withdrawRequest.getId();
//		final var amount = withdrawRequest.getAmount();
//		final var result = service.withdraw(id, amount);
//		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
//		return ResponseEntity.ok().body(result);
//	}
//
//	@PostMapping("/delete)
//			public ResponseEntity<PurchaseDetails> deletePurchaseDetails(@Validated @RequestBody DeletePurchaseDetailsRequest updatePurchaseDetailsRequest) throws IOException {
//		final var id = withdrawRequest.getId();
//		final var amount = withdrawRequest.getAmount();
//		final var result = service.withdraw(id, amount);
//		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
//		return ResponseEntity.ok().body(result);
//	}
//}