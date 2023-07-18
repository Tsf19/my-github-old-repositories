package com.tousif.InjectingCollections10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("InjectingCollections10.xml");
		JavaCollections jc =(JavaCollections)context.getBean("javaCollections");

		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
	
	}

}
