package com.oburnett127.lms.services;

import com.oburnett127.lms.daos.VideoDao;
import com.oburnett127.lms.models.Video;
import com.oburnett127.lms.utils.VideoValidator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class VideoService implements VideoOperations {

	private final VideoDao VideoDao;
	private final VideoValidator VideoValidator;

	public VideoService(final VideoDao VideoDao, final VideoValidator VideoValidator) {
		this.VideoDao = VideoDao;
		this.VideoValidator = VideoValidator;
	}

	@Override
	public List<Video> listAll() {
		return this.VideoDao.getAll();
	}

	@Override
	public void createVideo(Video Video) {
		this.VideoDao.create(Video);
	}

	@Override
	@SneakyThrows
	public Video getVideo(final UUID id) {
		final var Video = VideoDao.getVideo(id);

		return Video;
	}

	@Override
	@SneakyThrows
	public Video withdraw(UUID id, BigDecimal amount) {
		final var Video = VideoDao.getVideo(id);

		VideoValidator.withdraw(Video, amount);

		Video.setBalance(Video.getBalance().subtract(amount));

		VideoDao.save(Video);

		return Video;
	}

	@Override
	@SneakyThrows
	public Video deposit(UUID id, BigDecimal amount) {
		final var Video = VideoDao.getVideo(id);

		VideoValidator.deposit(id, amount);

		log.debug("Video.getId() {}", Video.getId());
		log.debug("Video balance: {} amount: {}", Video.getBalance(), amount);

		Video.setBalance(Video.getBalance().add(amount));

		VideoDao.save(Video);

		return Video;
	}

	@Override
	@SneakyThrows
	public Video depositCheck(UUID id, String fullName, String signature, BigDecimal amount) {
		final var Video = VideoDao.getVideo(id);

		VideoValidator.depositCheck(id, fullName, signature, amount);

		Video.setBalance(Video.getBalance().add(amount));

		VideoDao.save(Video);

		return Video;
	}

	@Override
	@SneakyThrows
	public Video transfer(UUID idSender, UUID idReceiver, BigDecimal amount) {
		final var senderVideo = VideoDao.getVideo(idSender);
		final var receiverVideo = VideoDao.getVideo(idReceiver);

		VideoValidator.transfer(senderVideo, receiverVideo, amount);

		senderVideo.setBalance(senderVideo.getBalance().subtract(amount));
		receiverVideo.setBalance(receiverVideo.getBalance().add(amount));

		VideoDao.save(senderVideo);
		VideoDao.save(receiverVideo);

		return senderVideo;
	}
}