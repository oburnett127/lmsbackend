package com.oburnett127.lms.daos;

import com.oburnett127.lms.mappers.PurchaseMapper;
import com.oburnett127.lms.models.Purchase;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PurchaseDao {
    private final SqlSessionFactory sqlSessionFactory;

    public PurchaseDao(final SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Purchase getPurchase(final UUID id) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(PurchaseMapper.class);
            final var Purchase = mapper.getPurchase(id);
            return Purchase;
        }
    }

    public List<Purchase> getAll() {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(PurchaseMapper.class);
            final var Purchases = mapper.getAll();
            return Purchases;
        }
    }

    public void save(final Purchase Purchase) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(PurchaseMapper.class);
            mapper.save(Purchase);
            session.commit();
        }
    }

    public void create(final Purchase Purchase) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(PurchaseMapper.class);
            mapper.create(Purchase);
            session.commit();
        }
    }
}