//package com.oburnett127.lms.daos;
//
//import com.oburnett127.lms.mappers.CartMapper;
//import com.oburnett127.lms.models.Cart;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.UUID;
//
//@Component
//public class CartDao {
//    private final SqlSessionFactory sqlSessionFactory;
//
//    public CartDao(final SqlSessionFactory sqlSessionFactory) {
//        this.sqlSessionFactory = sqlSessionFactory;
//    }
//
//    public Cart getCart(final UUID id) {
//        try (final var session = sqlSessionFactory.openSession()) {
//            final var mapper = session.getMapper(CartMapper.class);
//            final var Cart = mapper.getCart(id);
//            return Cart;
//        }
//    }
//
//    public List<Cart> getAll() {
//        try (final var session = sqlSessionFactory.openSession()) {
//            final var mapper = session.getMapper(CartMapper.class);
//            final var Carts = mapper.getAll();
//            return Carts;
//        }
//    }
//
//    public void save(final Cart Cart) {
//        try (final var session = sqlSessionFactory.openSession()) {
//            final var mapper = session.getMapper(CartMapper.class);
//            mapper.save(Cart);
//            session.commit();
//        }
//    }
//
//    public void create(final Cart Cart) {
//        try (final var session = sqlSessionFactory.openSession()) {
//            final var mapper = session.getMapper(CartMapper.class);
//            mapper.create(Cart);
//            session.commit();
//        }
//    }
//}