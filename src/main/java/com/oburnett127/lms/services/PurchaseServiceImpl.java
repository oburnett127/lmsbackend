package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Purchase;
import com.oburnett127.MyEcomm.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("purchaseService")
public class PurchaseServiceImpl implements com.oburnett127.MyEcomm.service.PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Override
	public Purchase createPurchase(Purchase purchase) {
		return purchaseRepository.createPurchase(purchase);
	}
	
	@Override
	public Purchase getPurchase(Integer id) {
		return purchaseRepository.getPurchase(id);
	}
	
	@Override
	public List<Purchase> getPurchases() {
		return purchaseRepository.getPurchases();
	}
	
//	@Override
//	public Purchase updatePurchase(Purchase purchase) {
//		return purchaseRepository.updatePurchase(purchase);
//	}
	
	@Override
	public void deletePurchase(Integer id) {
		purchaseRepository.deletePurchase(id);
	}
}