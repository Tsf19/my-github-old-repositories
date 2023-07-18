package com.tousif._1_2_AnnotationConfigDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */
public class App {

	/**
	 * Annotation injection is performed before XML injection. 
	 * Thus, the latter configuration will override the former for properties wired through both approaches.
	 */
	 
	public static void main(String[] args) {

		
		//1.
		ApplicationContext context = new ClassPathXmlApplicationContext("AnnotationBasedConfig.xml");
				
		Vehicle obj = (Vehicle)context.getBean("car");
		//By Default Name is decapitalize name of class(Car=car, Bike=bike) 
		
		obj.drive();
		
		
		Tyre tyre = (Tyre)context.getBean("tyre");
		System.out.println("Vale of tyre Inside App.class: " + tyre);
		
		
	}

}
