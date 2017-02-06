package com.poultry.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.poultry.service.ProductService;
import com.poultry.ui.ElementType;
import com.poultry.ui.UIElement;
import com.poultry.vo.ProductVo;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(path = "product", method = RequestMethod.GET)
	public ModelAndView displayProduct() {

		ModelAndView mv = new ModelAndView("render");
		List<UIElement> uiElements = new ArrayList<UIElement>();
		UIElement productName = new UIElement();
		productName.setLabel("Product Name:");
		productName.setName("name");
		productName.setElementType(ElementType.TEXT);
		UIElement description = new UIElement();
		description.setLabel("Description:");
		description.setName("description");
		description.setElementType(ElementType.TEXTAREA);
		uiElements.add(productName);
		uiElements.add(description);
		mv.addObject("uiElements", uiElements);
		mv.addObject("action", "product.htm");
		return mv;
	}
	
	@RequestMapping(path = "product", method = RequestMethod.POST)
	public String saveProduct(ProductVo productVO) {
		System.out.println(productVO.getName());
		System.out.println(productVO.getDescription());
		
		productService.saveProduct(productVO);
		return "success";

	}

}
