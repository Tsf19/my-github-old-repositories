package com.tousif._1_1_XmlConfigDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

//		1.
//		Vehicle obj = new Car();
//		OR
//		Vehicle obj = new Bike();
		
//		We Don't want to Change what to drive car or bike in java code, because for every change we have to compile it
//		So We will make use of XML Configuration OR Annotations
		
//		So we will use getBean(), we can get this method from two Interfaces
//		1.BeanFactory		2.ApplicationContext
//		Both of above belongs to Spring FrameWork
		
//		ApplicationContext is a SUPERSET of BeanFactory,
//		for Small application, BeanFactory is preferred
//		for web application or enterprise application, ApplicationContext is used
		
		
//		2.
		ApplicationContext context = new ClassPathXmlApplicationContext("XmlBasedConfig.xml");
		//ApplicationContext is an Interface so to Implement it we have to use ClassPathXmlApplicationContext. 
		
		
		Vehicle obj = (Vehicle)context.getBean("vehicle");
//		getBean("vehicle"), what is vehicle? we have o define it inside <beans> tag in xml,
//		so creating a new xml (SpringDemo.xml) , and mention it in ClassPathXmlApplicationContext()
		
		obj.drive();
		
		
		Tyre tyre = (Tyre)context.getBean("tyre"); 
		System.out.println("Value of tyre inside App: " + tyre);
	}

}
