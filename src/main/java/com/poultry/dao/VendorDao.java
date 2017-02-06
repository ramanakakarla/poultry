package com.poultry.dao;

import org.springframework.stereotype.Repository;

import com.poultry.dao.entities.Vendor;

@Repository
public class VendorDao extends BaseDao<Vendor> {

	@Override
	public Class<Vendor> getPersistanceClass() {
		return Vendor.class;
	}

}
