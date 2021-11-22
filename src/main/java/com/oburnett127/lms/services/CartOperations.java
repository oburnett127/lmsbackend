package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Cart;

import java.util.List;

public interface CartOperations {

	Cart createCart(Cart Cart);

	List<Cart> getCarts();

	Cart getCart(Integer id);

	Cart updateCart(Cart Cart);

	void deleteCart(Integer id);

}