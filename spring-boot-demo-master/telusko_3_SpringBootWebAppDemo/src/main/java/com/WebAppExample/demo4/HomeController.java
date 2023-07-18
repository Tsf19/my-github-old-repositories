package com.WebAppExample.demo4;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

/*	@RequestMapping("home")
//	public String homeMethod( String name, HttpSession session ) {	//1.
	public String homeMethod( @RequestParam("name") String myName, HttpSession session ) {
		
		System.out.println(myName+" Inside HomeController.homeMethod()");
		
		session.setAttribute("name", myName); //2.3 Data
		
		return "home"; //2.4 View
//		2.1 Whatever we are returning here is actually going to DispatcherServlet
//		2.2 DispatcherServlet is an special thing inside an SpringMVC
//		DispatcherServlet needs Two things : i)The Data  &  ii)ViewName and the combination of Two is called as ModelAndView  
	} */
	
//	USING ModelAndView
	
	@RequestMapping("home")
	public ModelAndView homeMethod( @RequestParam("name") String myName) { //3.2 Change Return Type and Remove HttpSession
		
		System.out.println(myName+" Inside HomeController.homeMethod()");

		ModelAndView mv = new ModelAndView(); // 3.1
		
		mv.addObject("name",myName); //4.
		mv.setViewName("home");	//5.
		
		
		return mv; //3.3 // Return ModelAndView Object
	}
	
}
