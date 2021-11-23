//package com.oburnett127.lms.controllers;
//
//import com.oburnett127.lms.models.Video;
//import com.oburnett127.lms.services.VideoOperations;
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
//public class VideoController {
//
//	private final VideoOperations service;
//
//	public VideoController(final VideoOperations service){
//		this.service = service;
//	}
//
//	@GetMapping("/view")
//	public ResponseEntity<List<Video>> view() {
//		final var result = service.listAll();
//		return ResponseEntity.ok().body(result);
//	}
//
//	@GetMapping("/Video")
//	public ResponseEntity<Video> getVideo(@Validated @RequestBody VideoRequest VideoRequest) {
//		final var Video = service.getVideo(VideoRequest.getId());
//		return ResponseEntity.ok().body(Video);
//	}
//
//
//	@PostMapping("/create")
//	public ResponseEntity<Video> createVideo(@Validated @RequestBody CreateVideoRequest createVideoRequest) throws IOException {
//		final var Video = Video.builder()
//				.email(createVideoRequest.getEmail())
//				.phone(createVideoRequest.getPhone())
//				.firstName(createVideoRequest.getFirstName())
//				.lastName(createVideoRequest.getLastName())
//				.password(createVideoRequest.getPassword())
//				.is_admin(createVideoRequest.isAdmin())
//				.build();
//		service.createVideo(Video);
//		log.debug(DebugMessage.MSG5,Video.getFullName(),Video.getId());
//
//
//		return ResponseEntity.ok(Video);
//	}
//
//	@PostMapping("/update)
//			public ResponseEntity<Video> updateVideo(@Validated @RequestBody UpdateVideoRequest updateVideoRequest) throws IOException {
//		final var id = withdrawRequest.getId();
//		final var amount = withdrawRequest.getAmount();
//		final var result = service.withdraw(id, amount);
//		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
//		return ResponseEntity.ok().body(result);
//	}
//
//	@PostMapping("/delete)
//			public ResponseEntity<Video> deleteVideo(@Validated @RequestBody DeleteVideoRequest updateVideoRequest) throws IOException {
//		final var id = withdrawRequest.getId();
//		final var amount = withdrawRequest.getAmount();
//		final var result = service.withdraw(id, amount);
//		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
//		return ResponseEntity.ok().body(result);
//	}
//}