package com.WebAppExample.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebAppDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebAppDemo1Application.class, args);
		
		System.out.println("Hello SpringBootWebAppDemo1Application");
		
//		1. Acceptin Client Data and printing it into a JSP page using HttpServletRequest & HttpSession objects
		
//		2. url to send client data --> http://localhost:8080/home?name=Tousif
		
//		3. If you don't want to use HttpServletRequest then refer package com.WebAppExample.demo3;
	
	}

}

