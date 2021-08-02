package com.oburnett127.lms.repository.utils;

import com.oburnett127.MyEcomm.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setAccountId(rs.getInt("accountId"));
		account.setEmail(rs.getString("email"));
		account.setFirstName(rs.getString("firstName"));
		account.setLastName(rs.getString("lastName"));
		account.setPassword(rs.getString("password"));
		account.setAdmin(rs.getBoolean("isAdmin"));
		
		return account;
	}
}
