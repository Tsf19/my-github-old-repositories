package com.tousif.ConstructorBasedDependencyInjection7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ConstructorBasedDependencyInjection7.xml");
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck();
	      textEditor.spellCorrect();
		
	}
	
//	1.
//	There may be an ambiguity while passing arguments to the constructor,
//	in case there are more than one parameters in constructor.
//	To resolve this ambiguity,
//	the order in which the constructor arguments are defined in a bean definition
//	is the order in which those arguments are supplied to the appropriate constructor.
	
//	Inside textEditor bean :
//    <constructor-arg ref = "spellChecker"/>
//    <constructor-arg ref = "spellCorrector"/>
//	This Sequence will be only used to pass argument in Constructor
//	Refer 2. in ConstructorBasedDependencyInjection7.xml
	
	
//	3.
//	The best way to pass constructor arguments,
//	use the index attribute to specify explicitly the index of constructor arguments.
//	Here, the index is 0 based.
//	Refer 4. in ConstructorBasedDependencyInjection7.xml
	
}
