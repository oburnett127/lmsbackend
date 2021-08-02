package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.PurchaseDetails;

import java.util.List;

public interface PurchaseDetailsService {

	PurchaseDetails createPurchaseDetails(PurchaseDetails PurchaseDetails);
	
	List<PurchaseDetails> getPurchasesDetails();
	
	PurchaseDetails getPurchaseDetails(Integer id);

	PurchaseDetails updatePurchaseDetails(PurchaseDetails PurchaseDetails);

	void deleteSinglePurchaseDetails(Integer purchaseId, Integer productId);
	
	void deleteAllPurchaseDetails(Integer purchaseId);
}