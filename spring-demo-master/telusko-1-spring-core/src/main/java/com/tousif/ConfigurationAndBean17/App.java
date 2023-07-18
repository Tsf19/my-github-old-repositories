package com.tousif.ConfigurationAndBean17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 ** @Configuration & @Bean Annotations :
 * 
 *** Annotating a class with the @Configuration indicates that
 *   the class can be used by the Spring IoC container as a source of bean definitions.
 * 
 *** The @Bean annotation tells Spring that a method annotated with @Bean
 *   will return an object that should be registered as a bean in the Spring application context.
 * 
 * @see https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
 */

public class App {


	public static void main(String[] args) {

//		ApplicationContext context = new ClassPathXmlApplicationContext("ConfigurationAndBean17.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(XmlAlternativeConfigClass.class);
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      SpellChecker spellChecker = (SpellChecker) context.getBean("spellChecker");
	      
	      textEditor.setSpellChecker(spellChecker);
	      textEditor.spellCheck();
		
	}
}

