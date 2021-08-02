package com.oburnett127.lms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
	private int purchaseId;
	private int accountId;
	private String purchaseDate;
	private com.oburnett127.lms.model.PurchaseDetails purchaseDetails;
	private BillingInfo billingInfo;
}