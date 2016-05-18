package org.mum.hotel.service;

import org.mum.hotel.dao.BillingDAO;
import org.mum.hotel.domain.Billing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BillingService {
	@Autowired
	protected BillingDAO billingDao;
	
	public void addBilling(Billing billing){
		billingDao.addBill(billing);
	}

}
