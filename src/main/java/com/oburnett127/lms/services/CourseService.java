package com.oburnett127.lms.services;

import com.oburnett127.lms.daos.CourseDao;
import com.oburnett127.lms.models.Course;
import com.oburnett127.lms.utils.CourseValidator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CourseService implements CourseOperations {

	private final CourseDao CourseDao;
	private final CourseValidator CourseValidator;

	public CourseService(final CourseDao CourseDao, final CourseValidator CourseValidator) {
		this.CourseDao = CourseDao;
		this.CourseValidator = CourseValidator;
	}

	@Override
	public List<Course> listAll() {
		return this.CourseDao.getAll();
	}

	@Override
	public void createCourse(Course Course) {
		this.CourseDao.create(Course);
	}

	@Override
	@SneakyThrows
	public Course getCourse(final UUID id) {
		final var Course = CourseDao.getCourse(id);

		return Course;
	}

	@Override
	@SneakyThrows
	public Course withdraw(UUID id, BigDecimal amount) {
		final var Course = CourseDao.getCourse(id);

		CourseValidator.withdraw(Course, amount);

		Course.setBalance(Course.getBalance().subtract(amount));

		CourseDao.save(Course);

		return Course;
	}

	@Override
	@SneakyThrows
	public Course deposit(UUID id, BigDecimal amount) {
		final var Course = CourseDao.getCourse(id);

		CourseValidator.deposit(id, amount);

		log.debug("Course.getId() {}", Course.getId());
		log.debug("Course balance: {} amount: {}", Course.getBalance(), amount);

		Course.setBalance(Course.getBalance().add(amount));

		CourseDao.save(Course);

		return Course;
	}

	@Override
	@SneakyThrows
	public Course depositCheck(UUID id, String fullName, String signature, BigDecimal amount) {
		final var Course = CourseDao.getCourse(id);

		CourseValidator.depositCheck(id, fullName, signature, amount);

		Course.setBalance(Course.getBalance().add(amount));

		CourseDao.save(Course);

		return Course;
	}

	@Override
	@SneakyThrows
	public Course transfer(UUID idSender, UUID idReceiver, BigDecimal amount) {
		final var senderCourse = CourseDao.getCourse(idSender);
		final var receiverCourse = CourseDao.getCourse(idReceiver);

		CourseValidator.transfer(senderCourse, receiverCourse, amount);

		senderCourse.setBalance(senderCourse.getBalance().subtract(amount));
		receiverCourse.setBalance(receiverCourse.getBalance().add(amount));

		CourseDao.save(senderCourse);
		CourseDao.save(receiverCourse);

		return senderCourse;
	}
}