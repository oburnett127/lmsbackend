package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.PurchaseDetails;

import java.util.List;

public interface PurchaseDetailsOperations {

	PurchaseDetails createPurchaseDetails(PurchaseDetails PurchaseDetails);

	List<PurchaseDetails> getPurchaseDetailss();

	PurchaseDetails getPurchaseDetails(Integer id);

	PurchaseDetails updatePurchaseDetails(PurchaseDetails PurchaseDetails);

	void deletePurchaseDetails(Integer id);

}