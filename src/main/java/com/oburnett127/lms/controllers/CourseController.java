package com.oburnett127.lms.controllers;

import com.oburnett127.lms.models.Course;
import com.oburnett127.lms.services.CourseOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@Slf4j
public class CourseController {

	private final CourseOperations service;

	public CourseController(final CourseOperations service){
		this.service = service;
	}

	@GetMapping("/view")
	public ResponseEntity<List<Course>> view() {
		final var result = service.listAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/Course")
	public ResponseEntity<Course> getCourse(@Validated @RequestBody CourseRequest CourseRequest) {
		final var Course = service.getCourse(CourseRequest.getId());
		return ResponseEntity.ok().body(Course);
	}


	@PostMapping("/create")
	public ResponseEntity<Course> createCourse(@Validated @RequestBody CreateCourseRequest createCourseRequest) throws IOException {
		final var Course = Course.builder()
				.email(createCourseRequest.getEmail())
				.phone(createCourseRequest.getPhone())
				.firstName(createCourseRequest.getFirstName())
				.lastName(createCourseRequest.getLastName())
				.password(createCourseRequest.getPassword())
				.is_admin(createCourseRequest.isAdmin())
				.build();
		service.createCourse(Course);
		log.debug(DebugMessage.MSG5,Course.getFullName(),Course.getId());


		return ResponseEntity.ok(Course);
	}

	@PostMapping("/update)
	public ResponseEntity<Course> updateCourse(@Validated @RequestBody UpdateCourseRequest updateCourseRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/delete)
			public ResponseEntity<Course> deleteCourse(@Validated @RequestBody DeleteCourseRequest updateCourseRequest) throws IOException {
		final var id = withdrawRequest.getId();
		final var amount = withdrawRequest.getAmount();
		final var result = service.withdraw(id, amount);
		log.debug(DebugMessage.MSG6, amount, result.getId(), result.getBalance());
		return ResponseEntity.ok().body(result);
	}
}