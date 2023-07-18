package com.tousif.LifecycleCallbacksAndBeanScope19;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 **  The Lifecycle Callbacks :
 * 
 *** The @Bean annotation supports specifying arbitrary initialization and destruction callback methods,
 * 	 much like Spring XML's init-method and destroy-method attributes on the bean element −
 * 
 *** The default scope is singleton, but you can override this with the @Scope annotation.
 * 
 * @see https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
 * 
 * NOTE :
 * Destroy method is not called for beans of scope prototype.
 * This is because the context doesn't keep track of the prototype scope objects
 * (if it does, it will cause a memory leak as spring doesn't know when to dispose it)
 * @see https://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch04s04.html#beans-factory-scopes-prototype
 *
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
/**
 **OUTPUT :
 * Inside TextEditor constructor..
 * Inside SpellChecker constructor..
 * Inside spellCheckerInit()..
 * Inside spellCheck..
 * Editor Name is : General Text Editor
 * Inside checkSpelling..
 *
 */