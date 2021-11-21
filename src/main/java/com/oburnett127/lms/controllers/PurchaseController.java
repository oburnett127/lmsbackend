package com.oburnett127.lms.controllers;


import com.oburnett127.MyEcomm.model.Purchase;
import com.oburnett127.MyEcomm.service.PurchaseService;
import com.oburnett127.MyEcomm.util.ServiceError;
import com.oburnett127.lms.models.Purchase;
import com.oburnett127.lms.services.PurchaseOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PurchaseController {
	@Autowired
	private PurchaseOperations purchaseService;
	
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public @ResponseBody Purchase createPurchase(@RequestBody Purchase purchase) {
		return purchaseService.createPurchase(purchase);
	}
	
	@RequestMapping(value = "/purchases", method = RequestMethod.GET)
	public @ResponseBody List<Purchase> getPurchases() {
		return purchaseService.getPurchases();
	}
	
	@RequestMapping(value = "/purchase/{id}", method = RequestMethod.GET)
	public @ResponseBody Purchase getPurchase(@PathVariable(value="id") Integer id) {
		return purchaseService.getPurchase(id);
	}
	
	@RequestMapping(value = "/purchase", method = RequestMethod.PUT)
	public @ResponseBody Purchase updatePurchase(@RequestBody Purchase Purchase) {
		return purchaseService.updatePurchase(Purchase);
	}
	
	@RequestMapping(value = "/purchase/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
		purchaseService.deletePurchase(id);
		return null;
	}
}