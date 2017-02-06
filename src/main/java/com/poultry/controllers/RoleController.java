package com.poultry.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.poultry.service.RoleService;
import com.poultry.ui.ElementType;
import com.poultry.ui.UIElement;
import com.poultry.vo.RoleVo;

@Controller
public class RoleController {
	@Autowired
	RoleService  roleService;
	
	@RequestMapping(path = "role" , method = RequestMethod.GET)
	public ModelAndView displayRole(){
		ModelAndView mnv = new ModelAndView("render");
		List<UIElement> uiElements = new ArrayList<UIElement>();
		UIElement code = new UIElement();
		code.setLabel("Code : ");
		code.setName("code");
		code.setElementType(ElementType.TEXT);
		UIElement description = new UIElement();
		description.setLabel("Description : ");
		description.setName("description");
		description.setElementType(ElementType.TEXTAREA);
		uiElements.add(code);
		uiElements.add(description);
		mnv.addObject("uiElements", uiElements);
		mnv.addObject("action", "role.htm");
		return mnv;
	}
	@RequestMapping(path = "role" , method = RequestMethod.POST)
	public String saveRole(RoleVo roleVo){
		System.out.println(roleVo.getCode());
		roleService.saveRole(roleVo);
		return "addrole";
		
	}

}
