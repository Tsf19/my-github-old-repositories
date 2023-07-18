package com.WebAppExample.demo3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


	@RequestMapping("home")
//	public String homeMethod(HttpServletRequest request) {	//1.1
	public String homeMethod( String name, HttpSession session ) {	//2.
//	4.Automatically we get object of HttpSession (Dependency Injection)
//	5. The "name" variable in "http://localhost:8080/home?name=Tousif" and "name" variable in "String homeMethod()" must be same
//	6. If we want to use different variable name in ClientSide and different variable name in homeMethod() then refer "com.WebAppExample.demo4;"
		
		
//		String name = request.getParameter("name");	//1.2
		
		System.out.println(name+" Inside HomeController.homeMethod()");
		
//		HttpSession session = request.getSession(); //3.
		session.setAttribute("name", name);
		
		return "home";
		
	}
	
}
