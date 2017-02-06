package com.poultry.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.poultry.ui.ElementType;
import com.poultry.ui.UIElement;
import com.poultry.vo.UserVO;
@Controller
public class UserController<User> {
	@RequestMapping(path = "user" , method = RequestMethod.GET)
	public ModelAndView displayRole(){
		ModelAndView mnv = new ModelAndView("render");
		List<UIElement> uiElements = new ArrayList<UIElement>();
		UIElement userName = new UIElement();
		userName.setLabel("Username : ");
		userName.setName("userName");
		userName.setElementType(ElementType.TEXT);
		UIElement password = new UIElement();
		password.setLabel("Password : ");
		password.setName("password");
		password.setElementType(ElementType.PASSWORD);
		UIElement address = new UIElement();
		address.setLabel("address : ");
		address.setName("address");
		address.setElementType(ElementType.TEXTAREA);
		uiElements.add(userName);
		uiElements.add(password);
		uiElements.add(address);
		mnv.addObject("uiElements", uiElements);
		mnv.addObject("action", "user.htm");
		return mnv;
	}
	@RequestMapping(path = "user" , method = RequestMethod.POST)
	public String saveRole(UserVO user){
		System.out.println(user.getUserName()) ;
		return "adduser";
	}


 
	 
		
		 
	
	 
		
	}


