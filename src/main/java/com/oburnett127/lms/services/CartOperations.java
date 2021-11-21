package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Cart;

public interface CartOperations {

	Cart createCart(Cart Cart);
	
	Cart getCart(Integer id);
	
	//List<Cart> getCarts();

	//Cart updateCart(Cart Cart);

	//void deleteCart(Integer id);

}