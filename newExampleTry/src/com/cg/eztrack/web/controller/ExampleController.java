package com.cg.eztrack.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan(basePackages = "com.cg.eztrack")
public class ExampleController {

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@RequestMapping("/test1")
	// @ResponseStatus(value = HttpStatus.CONFLICT)
	public String handleRequest1(ModelMap model) throws Exception {
		// final String methodName = "handleRequest1";
		// final String ip = request.getRemoteAddr();

		/*
		 * if (session == null) { System.out.println("Session is  null"); } else {
		 * System.out.println("Session is not null");
		 * 
		 * session.setAttribute("bass1", "Setting Session 1");
		 * LoggerManager.writeInfoLog(ip, ExampleController.class.getName(), methodName,
		 * "Setting Session 1"); session.setAttribute("bass2", "Setting Session 2");
		 * session.setAttribute("bass3", "Setting Session 3"); }
		 */

		model.addAttribute("greeting", "Hello World Again, from test1");
		return "welcome";

	}

	@RequestMapping("/test2")
	public String handleRequest2(ModelMap model) throws Exception {

		/*
		 * if (session == null) { System.out.println("Session is  null in test2"); }
		 * else { System.out.println("Session is not null"); String syso1 = (String)
		 * session.getAttribute("bass1"); String syso2 = (String)
		 * session.getAttribute("bass2"); String syso3 = (String)
		 * session.getAttribute("bass3");
		 * 
		 * System.out.println(syso1.concat(" ExampleController "));
		 * System.out.println(syso2.concat(" ExampleController "));
		 * System.out.println(syso3.concat(" ExampleController ")); }
		 */

		model.addAttribute("greeting", "Hello World Again, from test2");

		return "welcome";
	}

	@RequestMapping("/test3")
	// @ResponseStatus(value = HttpStatus.CONFLICT)
	public String handleRequest3() throws Exception {

		String msg = String.format("Test exception from class: %s", this.getClass().getSimpleName(),
				"Method handleRequest1");

		throw new Exception(msg);

	}

}
