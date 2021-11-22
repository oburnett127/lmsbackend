package com.oburnett127.lms.daos;

import com.oburnett127.lms.mappers.RatingMapper;
import com.oburnett127.lms.models.Rating;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RatingDao {
    private final SqlSessionFactory sqlSessionFactory;

    public RatingDao(final SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Rating getRating(final UUID id) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(RatingMapper.class);
            final var Rating = mapper.getRating(id);
            return Rating;
        }
    }

    public List<Rating> getAll() {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(RatingMapper.class);
            final var Ratings = mapper.getAll();
            return Ratings;
        }
    }

    public void save(final Rating Rating) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(RatingMapper.class);
            mapper.save(Rating);
            session.commit();
        }
    }

    public void create(final Rating Rating) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(RatingMapper.class);
            mapper.create(Rating);
            session.commit();
        }
    }
}