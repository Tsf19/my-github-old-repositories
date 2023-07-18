package com.tousif.ConstructorBasedDependencyInjection8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ConstructorBasedDependencyInjection8.xml");
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.printDayDate();
		
	}
	
//	1.
//	The container can also use type matching with simple types,
//	if you explicitly specify the type of the constructor argument using the type attribute.
//	Order of "constructor-arg" can be any
	
//	*NOTE*
//	in case you are passing a reference to an object, you need to use ref attribute of <constructor-arg> tag
//	and if you are passing a value directly then you should use value attribute.
	
}
