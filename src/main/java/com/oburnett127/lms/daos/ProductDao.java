package com.oburnett127.bankmongo.daos;

import com.oburnett127.bankmongo.mappers.ProductMapper;
import com.oburnett127.bankmongo.models.Product;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductDao {
    private final SqlSessionFactory sqlSessionFactory;

    public ProductDao(final SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Product getProduct(final UUID id) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(ProductMapper.class);
            final var Product = mapper.getProduct(id);
            return Product;
        }
    }

    public List<Product> getAll() {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(ProductMapper.class);
            final var Products = mapper.getAll();
            return Products;
        }
    }

    public void save(final Product Product) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(ProductMapper.class);
            mapper.save(Product);
            session.commit();
        }
    }

    public void create(final Product Product) {
        try (final var session = sqlSessionFactory.openSession()) {
            final var mapper = session.getMapper(ProductMapper.class);
            mapper.create(Product);
            session.commit();
        }
    }
}