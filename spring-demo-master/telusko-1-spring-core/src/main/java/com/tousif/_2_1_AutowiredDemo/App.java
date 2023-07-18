package com.tousif._2_1_AutowiredDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("AutowiredDemo.xml");
				
		Tyre tyre = (Tyre)context.getBean("tyre");
		System.out.println("I'm inside App-" + tyre); //PRINT Brand only when there is mapping in XML
		
		Car obj = (Car)context.getBean("car");
		obj.drive();
		
		
		
	}

}
