package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.BillingInfo;

import java.util.List;

public interface BillingInfoService {

	BillingInfo createBillingInfo(BillingInfo BillingInfo);
	
	List<BillingInfo> getBillingInfos();
	
	BillingInfo getBillingInfo(Integer id);

	BillingInfo updateBillingInfo(BillingInfo BillingInfo);

	void deleteBillingInfo(Integer id);

}