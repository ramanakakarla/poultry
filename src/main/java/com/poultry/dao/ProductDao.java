package com.poultry.dao;

import org.springframework.stereotype.Repository;

import com.poultry.dao.entities.Product;
@Repository
public class ProductDao extends BaseDao<Product> {

	public ProductDao() {
	}

	@Override
	public Class<Product> getPersistanceClass() {
		return Product.class;
	}
	
	

}
