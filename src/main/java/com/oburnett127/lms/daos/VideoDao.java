package com.oburnett127.bankmongo.daos;

import com.oburnett127.bankmongo.mappers.VideoMapper;
import com.oburnett127.bankmongo.models.Video;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class VideoDao {
    private final SqlSessionFactory sqlSessionFactory;

    public VideoDao(final SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Video getVideo(final UUID id) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(VideoMapper.class);
            final var Video = mapper.getVideo(id);
            return Video;
        }
    }

    public List<Video> getAll() {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(VideoMapper.class);
            final var Videos = mapper.getAll();
            return Videos;
        }
    }

    public void save(final Video Video) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(VideoMapper.class);
            mapper.save(Video);
            session.commit();
        }
    }

    public void create(final Video Video) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(VideoMapper.class);
            mapper.create(Video);
            session.commit();
        }
    }
}