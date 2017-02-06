package com.poultry.dao;

import com.poultry.dao.entities.Customer;

public class CustomerDao extends BaseDao<Customer> {

	public CustomerDao() {
		// TODO Auto-generated constructor stub
	}
	
	


	@Override
	public Class<Customer> getPersistanceClass() {
		// TODO Auto-generated method stub
		return Customer.class;
	
	}


}
