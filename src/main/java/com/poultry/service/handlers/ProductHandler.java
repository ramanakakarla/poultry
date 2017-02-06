package com.poultry.service.handlers;

import com.poultry.dao.entities.Product;
import com.poultry.vo.ProductVo;

public class ProductHandler {
	
	public static ProductVo fromEntitytoVO(Product product){
		if(null == product){
			return new ProductVo();
		}
		ProductVo productVo = new ProductVo();
		productVo.setProductId(product.getProductId());
		productVo.setName(product.getName());
		productVo.setDescription(product.getDescription());
		return productVo;
	}

}
