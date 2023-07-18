package com.tousif.AutowiredOnSetter14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 * #AutowiredOnSetter
 * You can use @Autowired annotation on setter methods to get rid of the <property> element in XML configuration file.
 * When Spring finds an @Autowired annotation used with setter methods,
 * it tries to perform byType autowiring on the method.
 * 
 * @see https://www.tutorialspoint.com/spring/spring_autowired_annotation.htm
 */

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("AutowiredOnSetter14.xml");
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck();
		
	}
}
