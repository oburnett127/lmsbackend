package com.oburnett127.bankmongo.daos;

import com.oburnett127.bankmongo.mappers.CourseMapper;
import com.oburnett127.bankmongo.models.Course;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CourseDao {
    private final SqlSessionFactory sqlSessionFactory;

    public CourseDao(final SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Course getCourse(final UUID id) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(CourseMapper.class);
            final var Course = mapper.getCourse(id);
            return Course;
        }
    }

    public List<Course> getAll() {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(CourseMapper.class);
            final var Courses = mapper.getAll();
            return Courses;
        }
    }

    public void save(final Course Course) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(CourseMapper.class);
            mapper.save(Course);
            session.commit();
        }
    }

    public void create(final Course Course) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(CourseMapper.class);
            mapper.create(Course);
            session.commit();
        }
    }
}