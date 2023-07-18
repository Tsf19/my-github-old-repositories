package com.tousif.AutowiringByConstructor13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 * 1.#AutowiringByConstructor
 * This mode is very similar to byType, but it applies to constructor arguments.
 * Spring container looks at the beans on which autowire attribute is set constructor in the XML configuration file.
 * It then tries to match and wire its constructor's argument with exactly one of the beans name in the configuration file.
 * If matches are found, it will inject those beans. Otherwise, bean(s) will not be wired.
 *
 * For example, if a bean definition is set to autowire by constructor in configuration file,
 * and it has a constructor with one of the arguments of SpellChecker type,
 * Spring looks for a bean definition named SpellChecker, and uses it to set the constructor's argument.
 * Still you can wire remaining arguments using <constructor-arg> tags
 *
 * bean name can be "any"
 * <bean id = "anyName" class = "com.tousif.AutowiringByType13.SpellChecker"></bean>
 * 
 * @see https://www.tutorialspoint.com/spring/spring_autowiring_byconstructor.htm
 */

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("AutowiringByConstructor13.xml");
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck();
		
	}
}
