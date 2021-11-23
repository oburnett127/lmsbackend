//package com.oburnett127.lms.services;
//
//import com.oburnett127.lms.daos.CommentDao;
//import com.oburnett127.lms.models.Comment;
//import com.oburnett127.lms.utils.CommentValidator;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//@Slf4j
//public class CommentService implements CommentOperations {
//
//	private final CommentDao CommentDao;
//	private final CommentValidator CommentValidator;
//
//	public CommentService(final CommentDao CommentDao, final CommentValidator CommentValidator) {
//		this.CommentDao = CommentDao;
//		this.CommentValidator = CommentValidator;
//	}
//
//	@Override
//	public List<Comment> listAll() {
//		return this.CommentDao.getAll();
//	}
//
//	@Override
//	public Comment getComment(Integer id) {
//		return null;
//	}
//
//	@Override
//	public Comment updateComment(Comment Comment) {
//		return null;
//	}
//
//	@Override
//	public void deleteComment(Integer id) {
//
//	}
//
//	@Override
//	public void createComment(Comment Comment) {
//		this.CommentDao.create(Comment);
//	}
//
//	@Override
//	@SneakyThrows
//	public Comment getComment(final UUID id) {
//		final var Comment = CommentDao.getComment(id);
//
//		return Comment;
//	}
//
//	@Override
//	@SneakyThrows
//	public Comment withdraw(UUID id, BigDecimal amount) {
//		final var Comment = CommentDao.getComment(id);
//
//		CommentValidator.withdraw(Comment, amount);
//
//		Comment.setBalance(Comment.getBalance().subtract(amount));
//
//		CommentDao.save(Comment);
//
//		return Comment;
//	}
//
//	@Override
//	@SneakyThrows
//	public Comment deposit(UUID id, BigDecimal amount) {
//		final var Comment = CommentDao.getComment(id);
//
//		CommentValidator.deposit(id, amount);
//
//		log.debug("Comment.getId() {}", Comment.getId());
//		log.debug("Comment balance: {} amount: {}", Comment.getBalance(), amount);
//
//		Comment.setBalance(Comment.getBalance().add(amount));
//
//		CommentDao.save(Comment);
//
//		return Comment;
//	}
//
//	@Override
//	@SneakyThrows
//	public Comment depositCheck(UUID id, String fullName, String signature, BigDecimal amount) {
//		final var Comment = CommentDao.getComment(id);
//
//		CommentValidator.depositCheck(id, fullName, signature, amount);
//
//		Comment.setBalance(Comment.getBalance().add(amount));
//
//		CommentDao.save(Comment);
//
//		return Comment;
//	}
//
//	@Override
//	@SneakyThrows
//	public Comment transfer(UUID idSender, UUID idReceiver, BigDecimal amount) {
//		final var senderComment = CommentDao.getComment(idSender);
//		final var receiverComment = CommentDao.getComment(idReceiver);
//
//		CommentValidator.transfer(senderComment, receiverComment, amount);
//
//		senderComment.setBalance(senderComment.getBalance().subtract(amount));
//		receiverComment.setBalance(receiverComment.getBalance().add(amount));
//
//		CommentDao.save(senderComment);
//		CommentDao.save(receiverComment);
//
//		return senderComment;
//	}
//}