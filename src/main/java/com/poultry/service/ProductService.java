package com.poultry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poultry.dao.ProductDao;
import com.poultry.dao.entities.Product;
import com.poultry.service.handlers.ProductHandler;
import com.poultry.vo.ProductVo;

@Repository
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public ProductService() {
	}

	public boolean saveProduct(ProductVo productVo) {
		Product entity = new Product();
		entity.setName(productVo.getName());
		entity.setDescription(productVo.getDescription());
		productDao.save(entity);
		return true;
	}
	
	public List<ProductVo> getAllProducts(){
		
		List<ProductVo> productVOs = new ArrayList<ProductVo>();
		List<Product> productEntities = productDao.getAll();
		if(null == productEntities){
			return productVOs;
		}
		for(Product product : productEntities){
			productVOs.add(ProductHandler.fromEntitytoVO(product));
		}
		return productVOs;
	}
}
