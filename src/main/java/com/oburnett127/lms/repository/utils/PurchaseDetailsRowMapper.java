package com.oburnett127.lms.repository.utils;

import com.oburnett127.MyEcomm.model.PurchaseDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseDetailsRowMapper implements RowMapper<PurchaseDetails> {
	@Override
	public PurchaseDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		purchaseDetails.setPurchaseId(rs.getInt("purchaseId"));
		purchaseDetails.setProductId(rs.getInt("productId"));
		purchaseDetails.setQuantity(rs.getInt("quantity"));
		
		return purchaseDetails;
	}
}
