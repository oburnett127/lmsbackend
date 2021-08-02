package com.oburnett127.lms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetails {
	private int purchaseId;
	private int productId;
	private int quantity;
}