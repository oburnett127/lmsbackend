package com.oburnett127.lms.daos;

import com.oburnett127.lms.mappers.CommentMapper;
import com.oburnett127.lms.models.Comment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CommentDao {
    private final SqlSessionFactory sqlSessionFactory;

    public CommentDao(final SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Comment getComment(final UUID id) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(CommentMapper.class);
            final var Comment = mapper.getComment(id);
            return Comment;
        }
    }

    public List<Comment> getAll() {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(CommentMapper.class);
            final var Comments = mapper.getAll();
            return Comments;
        }
    }

    public void save(final Comment Comment) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(CommentMapper.class);
            mapper.save(Comment);
            session.commit();
        }
    }

    public void create(final Comment Comment) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(CommentMapper.class);
            mapper.create(Comment);
            session.commit();
        }
    }
}