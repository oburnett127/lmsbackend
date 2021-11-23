package com.oburnett127.lms.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {
	private int purchaseId;
	private int accountId;
	private String purchaseDate;
	private PurchaseDetails purchaseDetails;
	private String billFirstName;
	private String billLastName;
	private String billAddress;
	private String creditCardExpDate;
	private String creditCardPin;
	private String creditCardNum;
	private String creditCardName;}