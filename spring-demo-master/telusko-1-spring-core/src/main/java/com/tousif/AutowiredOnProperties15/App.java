package com.tousif.AutowiredOnProperties15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 * #AutowiredOnProperties
 * You can use @Autowired annotation on properties to get rid of the setter methods.
 * When you will pass values of autowired properties using <property>
 * Spring will automatically assign those properties with the passed values or references.
 * 
 * @see https://www.tutorialspoint.com/spring/spring_autowired_annotation.htm
 */

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("AutowiredOnProperties15.xml");
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck();
		
	}
}
