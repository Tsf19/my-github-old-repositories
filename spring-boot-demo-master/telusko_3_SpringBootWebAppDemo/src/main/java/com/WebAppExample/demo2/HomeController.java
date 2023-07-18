package com.WebAppExample.demo2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


	@RequestMapping("home")
	public String homeMethod(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		
		System.out.println(name+" Inside HomeController.homeMethod()");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		return "home";
		
	}
	
}
