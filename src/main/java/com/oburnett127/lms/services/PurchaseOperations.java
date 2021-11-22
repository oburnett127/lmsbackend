package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Purchase;

import java.util.List;

public interface PurchaseOperations {

	Purchase createPurchase(Purchase Purchase);

	List<Purchase> getPurchases();

	Purchase getPurchase(Integer id);

	Purchase updatePurchase(Purchase Purchase);

	void deletePurchase(Integer id);

}