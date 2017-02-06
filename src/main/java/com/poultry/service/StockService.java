package com.poultry.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poultry.dao.StockDao;
import com.poultry.dao.entities.Product;
import com.poultry.dao.entities.Stock;
import com.poultry.dao.entities.Vendor;
import com.poultry.vo.StockVo;

@Service
public class StockService {

	public StockService() {

	}

	@Autowired
	private StockDao stockdao;

	public boolean saveStock(StockVo stockVo) {
		Stock entity = new Stock();
		entity.setRepresentativeName(stockVo.getRepresentativeName());
		Product product = new Product();
		product.setProductId(stockVo.getProductId());
		entity.setProduct(product);
		entity.setStockDate(stockVo.getStockDate());
		entity.setQuantity(stockVo.getQuantity());
		Vendor vendor = new Vendor();
		vendor.setVendorId(stockVo.getVendorId());
		entity.setVendor(vendor);
		entity.setStockDate(Calendar.getInstance().getTime());
		stockdao.save(entity);
		return true;
	}

}
