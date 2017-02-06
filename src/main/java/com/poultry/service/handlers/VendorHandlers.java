package com.poultry.service.handlers;

import com.poultry.dao.entities.Vendor;
import com.poultry.vo.VendorVo;

public class VendorHandlers {
	
	public static VendorVo fromEntitytoVO(Vendor vendor){
		if(null == vendor){
			return new VendorVo();
		}
		VendorVo vendorVo = new VendorVo();
		vendorVo.setVendorId(vendor.getVendorId());
		vendorVo.setVendorName(vendor.getVendorName());
		vendorVo.setMobileNumber(vendor.getMobileNumber());
		vendorVo.setAddress(vendor.getAddress());
		return vendorVo;
	}

}
