package com.oburnett127.lms.daos;

import com.oburnett127.lms.mappers.PurchaseDetailsMapper;
import com.oburnett127.lms.models.PurchaseDetails;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PurchaseDetailsDao {
    private final SqlSessionFactory sqlSessionFactory;

    public PurchaseDetailsDao(final SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public PurchaseDetails getPurchaseDetails(final UUID id) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(PurchaseDetailsMapper.class);
            final var PurchaseDetails = mapper.getPurchaseDetails(id);
            return PurchaseDetails;
        }
    }

    public List<PurchaseDetails> getAll() {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(PurchaseDetailsMapper.class);
            final var PurchaseDetailss = mapper.getAll();
            return PurchaseDetailss;
        }
    }

    public void save(final PurchaseDetails PurchaseDetails) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(PurchaseDetailsMapper.class);
            mapper.save(PurchaseDetails);
            session.commit();
        }
    }

    public void create(final PurchaseDetails PurchaseDetails) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(PurchaseDetailsMapper.class);
            mapper.create(PurchaseDetails);
            session.commit();
        }
    }
}