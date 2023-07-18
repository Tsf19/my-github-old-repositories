package com.WebAppExample.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebAppDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebAppDemo1Application.class, args);
		
		System.out.println("Hello SpringBootWebAppDemo1Application");
		
//		1.1 To Create any WebPage like index.html, we need to create it inside webapp folder
//		1.2 Any WebPage should belong to webapp folder
//		1.3 So we need to create a folder --> src/main/webapp
		
//		2. Creating home.jsp inside "src/main/webapp"
		
//		3. Creating HomeController in "SpringBootWebAppDemo1/src/main/java" in "com.WebAppExample.demo1"
		
//		9.1 Now when I relaunch it and go to http://localhost:8080/home, it will download home.jsp file
//		9.2 JSP is a special type and when SpringBoot came into picture, RestAPIs and MicroServices were very famous
//		9.3 Their focus was on RestAPIs.
		
//		10. So by-default SpringBoot doesn't support JSP
		
//		13.1 so we need to add support for JSP in pom.xml,
//		13.2 GoTo mvnrepository.com --> Tomcat Jasper --> 9.0.14(Same as tomcat-embed version in your maven library)
		
//		14. Comment @ResponseBody in HomeController.java and relaunch and will get the output of JSP page
	}

}

