package com.tousif.AutowiringByName11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("AutowiringByName11.xml");
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck();
		
	}
	
//	1.
//	AutowiringByName mode specifies autowiring by property name.
//	Spring container looks at the beans on which auto-wire attribute is set to byName in the XML configuration file.
//	It then tries to match and wire its properties with the beans defined by the same names in the configuration file.
//	If matches are found, it will inject those beans. Otherwise, bean(s) will not be wired.

//	if a bean definition is set to autowire byName in the configuration file,
//	and it contains a spellChecker property (that is, it has a setSpellChecker(...)method),
//	Spring looks for a bean definition named spellChecker, and uses it to set the property.
//	Still you can wire the remaining properties using <property> tags.
	
//	bean name must be "spellChecker", any other name will throw "NullPointerException" -->
//	<bean id = "spellChecker" class = "com.tousif.AutowiringByName11.SpellChecker">
//	</bean>
	 

}
