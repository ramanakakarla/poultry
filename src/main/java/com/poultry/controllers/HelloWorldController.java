package com.poultry.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping(path="/hello")
public String sayHello(){
	return "hello";
}

}
