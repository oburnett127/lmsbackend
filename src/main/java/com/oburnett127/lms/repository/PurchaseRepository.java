package com.oburnett127.lms.repository;

import com.oburnett127.MyEcomm.model.Purchase;

import java.util.List;

public interface PurchaseRepository {

	Purchase createPurchase(Purchase purchase);
	
	List<Purchase> getPurchases();

	Purchase getPurchase(Integer id);

	//Purchase updatePurchase(Purchase purchase);

	void deletePurchase(Integer id);
}