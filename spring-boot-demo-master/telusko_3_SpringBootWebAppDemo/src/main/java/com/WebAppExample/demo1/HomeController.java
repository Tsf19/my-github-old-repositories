package com.WebAppExample.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


	@RequestMapping("home")
	public String homeMethod() {
		System.out.println("Inside HomeController.homeMethod()");
		
//		return "home.jsp"; 2.1
		return "home"; // 2.2 We don't normally mention extension like .jsp
		
//		3.1 To do any configuration, we have special file src/main/resources/application.properties
//		3.2 In application.properties we need to define prefix(NameOfPageFolder) and suffix(ExtensionOfPage)
		
//		To Accept Client Data, refer package com.WebAppExample.demo2
		
	}
	
}
