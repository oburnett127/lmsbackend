package com.oburnett127.lms.controllers;


import com.oburnett127.MyEcomm.model.PurchaseDetails;
import com.oburnett127.MyEcomm.service.PurchaseDetailsService;
import com.oburnett127.MyEcomm.service.PurchaseDetailsServiceImpl;
import com.oburnett127.MyEcomm.util.ServiceError;
import com.oburnett127.lms.models.PurchaseDetails;
import com.oburnett127.lms.services.PurchaseDetailsOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PurchaseDetailsController {
	@Autowired
	private PurchaseDetailsOperations purchaseDetailsService;
	
	public void setPurchaseDetailsService() {
		this.purchaseDetailsService = new PurchaseDetailsServiceImpl();
	}
	
	@RequestMapping(value = "/purchasedetails", method = RequestMethod.POST)
	public @ResponseBody
	PurchaseDetails createPurchaseDetails(@RequestBody PurchaseDetails purchaseDetails) {
		return purchaseDetailsService.createPurchaseDetails(purchaseDetails);
	}
	
	@RequestMapping(value = "/purchasesdetails", method = RequestMethod.GET)
	public @ResponseBody List<PurchaseDetails> getPurchaseDetails() {
		return purchaseDetailsService.getPurchasesDetails();
	}
	
	@RequestMapping(value = "/purchasedetails/{id}", method = RequestMethod.GET)
	public @ResponseBody PurchaseDetails getPurchaseDetails(@PathVariable(value="id") Integer id) {
		return purchaseDetailsService.getPurchaseDetails(id);
	}
	
	@RequestMapping(value = "/purchasedetails", method = RequestMethod.PUT)
	public @ResponseBody PurchaseDetails updatePurchaseDetails(@RequestBody PurchaseDetails PurchaseDetails) {
		return purchaseDetailsService.updatePurchaseDetails(PurchaseDetails);
	}
	
	@RequestMapping(value = "/purchasedetails/deleteSingle/{purchaseid}/{productid}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteSinglePurchaseDetails(@PathVariable(value="purchaseid") Integer purchaseid, @PathVariable(value="productid") Integer productid) {
		purchaseDetailsService.deleteSinglePurchaseDetails(purchaseid, productid);
	}
	
	@RequestMapping(value = "/purchasedetails/deleteAll/{purchaseid}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteAllPurchaseDetails(@PathVariable(value="purchaseid") Integer purchaseid) {
		purchaseDetailsService.deleteAllPurchaseDetails(purchaseid);
	}
}