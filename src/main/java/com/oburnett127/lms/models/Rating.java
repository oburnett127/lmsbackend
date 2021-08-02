package com.oburnett127.lms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	private int id;
	private Account account;
	private int rating;
	private Comment comment;
}