package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemo1Application {

	public static void main(String[] args) {
		
//		SpringApplication.run(SpringBootDemo1Application.class, args); //1.
		System.out.println("Hello SpringBoot World");
		
//		2.2 "SpringApplication.run" returns "ConfigurableApplicationContext" object
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemo1Application.class, args);//2.1
	
		Alien alien1 = context.getBean(Alien.class);
		alien1.show();
		
		Alien alien2 = context.getBean(Alien.class); //3.1 Printing "Alien Object Created" only One time
		alien2.show(); //3.2 Printing "In Alien.show()" Two Times
	
//		3.3 SpringBoot follows Many types of Scope, Two of Them are Core :  1)Singleton Scope & 2)Prototype Scope
//		3.4 By Default SpringBoot follows Singleton Scope, In Singleton, we get only one instance, So it will create only One Object for both alien1 & alien2
//		3.5 Hence, "Alien Object Created" only One time & Printing "In Alien.show()" Two Times
		
//		4.1 Even If we don't create an Alien object, it's still printing "Alien Object Created" One Time
//		4.2 Because By Default SpringBoot follows Singleton Design Pattern, so it will always gives object pre-hand whether we use it or not.
//		4.3 So we don't have to wait for object creation
		
//		6.1 Now we are Getting Both "Alien Object Created" & "In Alien.show()" Two times as we are now using Prototype Scope
//		6.2 Now If we don't create an Alien object, it's won't print "Alien Object Created" because it won't create any object now.
	}

}

