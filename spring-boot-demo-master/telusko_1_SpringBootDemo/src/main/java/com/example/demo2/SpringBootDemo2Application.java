package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemo2Application {

	public static void main(String[] args) {
		
		System.out.println("Hello SpringBoot World");
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemo2Application.class, args);//2.1
	
		Alien alien1 = context.getBean(Alien.class);
		alien1.show();
		
	
	}

}

