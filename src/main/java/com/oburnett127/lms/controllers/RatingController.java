package com.oburnett127.lms.controllers;

import com.oburnett127.lms.models.Rating;
import com.oburnett127.lms.services.RatingOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@Slf4j
public class RatingController {

	private final RatingOperations service;

	public RatingController(final RatingOperations service){
		this.service = service;
	}

	@GetMapping("/view")
	public ResponseEntity<List<Rating>> view() {
		final var result = service.listAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/Rating")
	public ResponseEntity<Rating> getRating(@Validated @RequestBody RatingRequest RatingRequest) {
		final var Rating = service.getRating(RatingRequest.getId());
		return ResponseEntity.ok().body(Rating);
	}


	@PostMapping("/create")
	public ResponseEntity<Rating> createRating(@Validated @RequestBody CreateRatingRequest createRatingRequest) throws IOException {
		final var Rating = Rating.builder()
				.email(createRatingRequest.getEmail())
				.phone(createRatingRequest.getPhone())
				.firstName(createRatingRequest.getFirstName())
				.lastName(createRatingRequest.getLastName())
				.password(createRatingRequest.getPassword())
				.is_admin(createRatingRequest.isAdmin())
				.build();
		service.createRating(Rating);
		log.debug(DebugMessage.MSG5,Rating.getFullName(),Rating.getId());


		return ResponseEntity.ok(Rating);
	}

	@PostMapping("/update)
	public ResponseEntity<Rating> updateRating(@Validated @RequestBody UpdateRatingRequest updateRatingRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/delete)
			public ResponseEntity<Rating> deleteRating(@Validated @RequestBody DeleteRatingRequest deleteRatingRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}
}