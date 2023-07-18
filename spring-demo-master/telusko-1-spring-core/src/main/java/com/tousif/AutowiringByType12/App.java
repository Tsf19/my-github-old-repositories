package com.tousif.AutowiringByType12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("AutowiringByType12.xml");
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck();
		
	}
	
//	1.AutowiringByType
//	This mode specifies autowiring by property type.
//	Spring container looks at the beans on which autowire attribute is set to byType in the XML configuration file.
//	It then tries to match and wire a property if its type matches with exactly one of the beans name in the configuration file.
//	If matches are found, it will inject those beans. Otherwise, bean(s) will not be wired.

//	For example, if a bean definition is set to autowire byType in the configuration file,
//	and it contains a spellChecker property of SpellChecker type,
//	Spring looks for a bean definition named SpellChecker,
//	and uses it to set the property.
//	Still you can wire the remaining properties using <property> tags.
	
//	 bean name can be "any"
//	 <bean id = "anyName" class = "com.tousif.AutowiringByType12.SpellChecker"></bean>
	 

}
