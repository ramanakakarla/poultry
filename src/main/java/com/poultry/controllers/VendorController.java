package com.poultry.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.poultry.service.VendorService;
import com.poultry.ui.ElementType;
import com.poultry.ui.UIElement;
import com.poultry.vo.VendorVo;

@Controller
public class VendorController {
	@Autowired
	VendorService vendorService;

	public VendorController() {
	}

	@RequestMapping(path = "vendor", method = RequestMethod.GET)
	public ModelAndView displayVendor() {
		ModelAndView mv = new ModelAndView("render");
		List<UIElement> uiElements = new ArrayList<UIElement>();
		UIElement vendorName = new UIElement();
		vendorName.setLabel("vendorName:");
		vendorName.setName("vendorName");
		vendorName.setElementType(ElementType.TEXT);
		UIElement mobileNumber = new UIElement();
		mobileNumber.setLabel("mobileNumber :");
		mobileNumber.setName("mobileNumber");
		mobileNumber.setElementType(ElementType.TEXT);
		UIElement address = new UIElement();
		address.setLabel("address:");
		address.setName("address");
		address.setElementType(ElementType.TEXTAREA);
		uiElements.add(vendorName);
		uiElements.add(mobileNumber);
		uiElements.add(address);
		mv.addObject("uiElements", uiElements);

		mv.addObject("action", "vendor.htm");

		return mv;

	}

	@RequestMapping(path = "vendor", method = RequestMethod.POST)
	public String saveVendor(VendorVo vendor) {
		System.out.println(vendor.getVendorName());
		System.out.println(vendor.getMobileNumber());
		System.out.println(vendor.getAddress());
		vendorService.saveVendor(vendor);
		return "success";

	}
}
