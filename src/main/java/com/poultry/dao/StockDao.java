package com.poultry.dao;

import org.springframework.stereotype.Repository;

import com.poultry.dao.entities.Stock;

@Repository
public class StockDao extends BaseDao<Stock> {

	@Override
	public Class<Stock> getPersistanceClass() {
		return Stock.class;
	}

}
