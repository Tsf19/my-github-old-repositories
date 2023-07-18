package com.tousif.InnerBean9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("InnerBean9.xml");
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck();
		
	}
	
//	1.
//	Inner Beans are beans that are defined within the scope of another bean.
//	Thus, a <bean/> element inside the <property/> or <constructor-arg/> elements is called Inner Bean

	
}
