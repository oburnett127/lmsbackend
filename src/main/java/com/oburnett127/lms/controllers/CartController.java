package com.oburnett127.lms.controllers;

import com.oburnett127.lms.models.Cart;
import com.oburnett127.lms.services.CartOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
	@Autowired
	private CartOperations cartService;
	
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public @ResponseBody
	Cart createCart(@RequestBody Cart cart) {
		return cartService.createCart(cart);
	}
	
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
	public @ResponseBody Cart getCart(@PathVariable(value="id") Integer id) {
		return cartService.getCart(id);
	}
}