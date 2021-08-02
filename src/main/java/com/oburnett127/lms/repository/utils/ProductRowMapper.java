package com.oburnett127.lms.repository.utils;

import com.oburnett127.MyEcomm.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setUnitPrice(rs.getBigDecimal("unitPrice"));
		product.setUnitsInStock(rs.getInt("unitsInStock"));
		return product;
	}
}
