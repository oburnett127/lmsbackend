package com.oburnett127.lms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment<DateTime> {
	private int id;
	private Account account;
	private int videoId;
	private int ratingId;
	private String text;
	private DateTime timeStamp;
}