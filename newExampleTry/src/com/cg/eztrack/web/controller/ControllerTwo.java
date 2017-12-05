package com.cg.eztrack.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerTwo {

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/task1", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {

		if (session == null) {
			System.out.println("Session is  null");
		} else {
			System.out.println("Session is not null");
			String syso = (String) session.getAttribute("bass");

			System.out.println(syso.concat(" From Controller Two"));
		}
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}

}
