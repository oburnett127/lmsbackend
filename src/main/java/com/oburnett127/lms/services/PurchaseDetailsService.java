package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.PurchaseDetails;
import com.oburnett127.MyEcomm.repository.PurchaseDetailsRepository;
import com.oburnett127.MyEcomm.repository.PurchaseDetailsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("purchaseDetailsService")
public class PurchaseDetailsService implements com.oburnett127.MyEcomm.service.PurchaseDetailsService {

	@Autowired
	private PurchaseDetailsRepository purchaseDetailsRepository;
	
	public void setPurchaseDetailsRepository() {
		this.purchaseDetailsRepository = new PurchaseDetailsRepositoryImpl();
	}
	
	@Override
	public PurchaseDetails createPurchaseDetails(PurchaseDetails purchaseDetails) {
		return purchaseDetailsRepository.createPurchaseDetails(purchaseDetails);
	}
	
	@Override
	public PurchaseDetails getPurchaseDetails(Integer id) {
		return purchaseDetailsRepository.getPurchaseDetails(id);
	}
	
	@Override
	public List<PurchaseDetails> getPurchasesDetails() {
		return purchaseDetailsRepository.getPurchasesDetails();
	}
	
	@Override
	public PurchaseDetails updatePurchaseDetails(PurchaseDetails purchaseDetails) {
		return purchaseDetailsRepository.updatePurchaseDetails(purchaseDetails);
	}
	
	@Override
	public void deleteSinglePurchaseDetails(Integer purchaseId, Integer productId) {
		purchaseDetailsRepository.deleteSinglePurchaseDetails(purchaseId, productId);
	}
	
	@Override
	public void deleteAllPurchaseDetails(Integer id) {
		purchaseDetailsRepository.deleteAllPurchaseDetails(id);
	}
}