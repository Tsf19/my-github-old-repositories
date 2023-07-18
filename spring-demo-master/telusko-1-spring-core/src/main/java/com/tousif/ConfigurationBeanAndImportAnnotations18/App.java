package com.tousif.ConfigurationBeanAndImportAnnotations18;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 ** The @Import Annotation :
 * 
 *** The @Import annotation allows for loading @Bean definitions from another configuration class.
 * 
 *** rather than needing to specify both XmlAlternativeConfigClassA.class and XmlAlternativeConfigClassB.class
 *   when instantiating the context, only ConfigB needs to be supplied as follows −
 *   ApplicationContext context = new AnnotationConfigApplicationContext(XmlAlternativeConfigClassB.class)
 * 
 * @see https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
 */

public class App {


	public static void main(String[] args) {

//		ApplicationContext context = new ClassPathXmlApplicationContext("ConfigurationAndBean17.xml");
//		ApplicationContext context = new AnnotationConfigApplicationContext(TextEditor.class, SpellChecker.class);
		ApplicationContext context = new AnnotationConfigApplicationContext(XmlAlternativeConfigClassB.class);
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      SpellChecker spellChecker = (SpellChecker) context.getBean("spellChecker");
	      
	      textEditor.setSpellChecker(spellChecker);
	      textEditor.spellCheck();
		
	}
}

