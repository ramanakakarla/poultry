package com.poultry.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poultry.dao.VendorDao;
import com.poultry.dao.entities.Vendor;
import com.poultry.service.handlers.VendorHandlers;
import com.poultry.vo.VendorVo;

@Service
public class VendorService {

	@Autowired
	private VendorDao vendorDao;

	@Transactional
	public boolean saveVendor(VendorVo vendorVo) {
		Vendor entity = new Vendor();

		entity.setVendorName(vendorVo.getVendorName());
		entity.setMobileNumber(vendorVo.getMobileNumber());
		entity.setAddress(vendorVo.getAddress());
		vendorDao.save(entity);
		return true;

	}
	
	public List<VendorVo> getAllVendords(){
		List<VendorVo> vendorVOs = new ArrayList<VendorVo>();
		List<Vendor> vendorEntities = vendorDao.getAll();
		if(null == vendorEntities){
			return vendorVOs;
		}
		for(Vendor vendor : vendorEntities){
			vendorVOs.add(VendorHandlers.fromEntitytoVO(vendor));
		}
		return vendorVOs;
	}

}
