package com.oburnett127.lms.controllers;

import com.oburnett127.MyEcomm.model.Comment;
import com.oburnett127.MyEcomm.service.CommentService;
import com.oburnett127.MyEcomm.util.ServiceError;
import com.oburnett127.lms.models.Comment;
import com.oburnett127.lms.models.CommentRequest;
import com.oburnett127.lms.models.CreateCommentRequest;
import com.oburnett127.lms.services.CommentOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@Slf4j
public class CommentController {

	private final CommentOperations service;

	public CommentController(final CommentOperations service){
		this.service = service;
	}

	@GetMapping("/view")
	public ResponseEntity<List<Comment>> view() {
		final var result = service.listAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/Comment")
	public ResponseEntity<Comment> getComment(@Validated @RequestBody CommentRequest CommentRequest) {
		final var Comment = service.getComment(CommentRequest.getId());
		return ResponseEntity.ok().body(Comment);
	}


	@PostMapping("/create")
	public ResponseEntity<Comment> createComment(@Validated @RequestBody CreateCommentRequest createCommentRequest) throws IOException {
		final var Comment = Comment.builder()
				.email(createCommentRequest.getEmail())
				.phone(createCommentRequest.getPhone())
				.firstName(createCommentRequest.getFirstName())
				.lastName(createCommentRequest.getLastName())
				.password(createCommentRequest.getPassword())
				.is_admin(createCommentRequest.isAdmin())
				.is_author(createCommentRequest.isAuthor())
				.build();
		service.createComment(Comment);
		log.debug(DebugMessage.MSG5,Comment.getFullName(),Comment.getId());


		return ResponseEntity.ok(Comment);
	}

	@PostMapping("/update)
			public ResponseEntity<Comment> updateComment(@Validated @RequestBody UpdateCommentRequest updateCommentRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/delete)
			public ResponseEntity<Comment> deleteComment(@Validated @RequestBody DeleteCommentRequest deleteCommentRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}
}