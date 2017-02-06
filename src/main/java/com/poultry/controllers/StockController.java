package com.poultry.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.poultry.service.ProductService;
import com.poultry.service.StockService;
import com.poultry.service.VendorService;
import com.poultry.ui.ElementType;
import com.poultry.ui.UIElement;
import com.poultry.vo.ProductVo;
import com.poultry.vo.StockVo;
import com.poultry.vo.VendorVo;

@Controller
public class StockController {

	@Autowired
	StockService stockService;
	
	@Autowired
	VendorService vendorService;

	@Autowired
	ProductService productService;
	
	public StockController() {
	}

	// @RequestMapping(path = "/stock.htm" method=RequestMethod.GET)
	@GetMapping(path = "/stock.htm")
	public ModelAndView getStockView() {
		ModelAndView modelAndView = new ModelAndView("render");
		List<UIElement> uiElements = new ArrayList<UIElement>();
		UIElement name = new UIElement();
		name.setLabel("Representative Name : ");
		name.setName("representativeName");
		name.setElementType(ElementType.TEXT);
		
		UIElement description = new UIElement();
		description.setLabel("description");
		description.setName("description");
		description.setElementType(ElementType.TEXTAREA);

		Map<String, String> vendorValues = new HashMap<String, String>();
		List<VendorVo>  vendorVos= vendorService.getAllVendords();
		for(VendorVo vendorVo : vendorVos){
			vendorValues.put(String.valueOf(vendorVo.getVendorId()), vendorVo.getVendorName());
		}
		UIElement vendorElement = new UIElement();
		vendorElement.setLabel("Vendor : ");
		vendorElement.setName("vendorId");
		vendorElement.setElementType(ElementType.DROPDOWN);
		vendorElement.setValues(vendorValues);
		
		Map<String, String> productValues = new HashMap<String, String>();
		List<ProductVo>  productVos= productService.getAllProducts();
		for(ProductVo productVo : productVos){
			productValues.put(String.valueOf(productVo.getProductId()), productVo.getName());
		}
		UIElement productElement = new UIElement();
		productElement.setLabel("Product : ");
		productElement.setName("productId");
		productElement.setElementType(ElementType.DROPDOWN);
		productElement.setValues(productValues);
		
		uiElements.add(description);
		uiElements.add(name);
		uiElements.add(vendorElement);
		uiElements.add(productElement);
		
		modelAndView.addObject("uiElements", uiElements);
		modelAndView.addObject("action", "stock.htm");
		return modelAndView;
	}

	
	@RequestMapping(path = "stock", method = RequestMethod.POST)
	public String saveProduct(StockVo stockVo) {
		stockService.saveStock(stockVo);
		return "success";

	}
}
