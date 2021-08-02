package com.oburnett127.lms.repository;

import com.oburnett127.MyEcomm.model.BillingInfo;

import java.util.List;

public interface BillingInfoRepository {

	BillingInfo createBillingInfo(BillingInfo billingInfo);
	
	List<BillingInfo> getBillingInfos();

	BillingInfo getBillingInfo(Integer id);

	BillingInfo updateBillingInfo(BillingInfo billingInfo);

	void deleteBillingInfo(Integer id);
}