package com.WebAppExample.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //5.
public class HomeController {

//	4.In Servlet we had an "service()" medthod

	@RequestMapping("home") //6. whenever we get request for "home", I want to execute this method
//	@ResponseBody //11. After Adding Response body, it's printing "home.jsp", not showing home.jsp page
	public String homeMethod() {
		System.out.println("Inside HomeController.homeMethod()");
		
		return "home.jsp";	//7. Return home.jsp to client	//12. But it's considering home.jsp as a data, not as a JSP page
		
//	8.1 SpringBoot has automatically configured it to search "home.jsp" inside src/main/webapp
//	8.2 If we are changing the path of "home.jsp" , then we need to configure it manually.
		
	}
	
}
