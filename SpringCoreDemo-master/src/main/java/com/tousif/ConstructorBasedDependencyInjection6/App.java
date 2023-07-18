package com.tousif.ConstructorBasedDependencyInjection6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ConstructorBasedDependencyInjection6.xml");
		
//		1. TextEditor textEditor is getting Bean(Object) of TextEditor
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck(); //TextEditor.class --> spellCheck() --> SpellChecker.class --> checkSpelling()
		
	}
	
//	2. Inside "textEditor" Bean in ConstructorBasedDependencyInjection6.xml, we have injected constructor argument of "spellChecker"
//	<constructor-arg ref = "spellChecker"/>

}
