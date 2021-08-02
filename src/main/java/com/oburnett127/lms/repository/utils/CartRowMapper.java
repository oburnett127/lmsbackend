package com.oburnett127.lms.repository.utils;

import com.oburnett127.MyEcomm.model.Cart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartRowMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		cart.setAccountId(rs.getInt("accountId"));
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		
		do {
			tempList.add(rs.getInt("productId"));
		} while(rs.next());
		
		cart.setProductIds(tempList);
		
		return cart;
	}
}
