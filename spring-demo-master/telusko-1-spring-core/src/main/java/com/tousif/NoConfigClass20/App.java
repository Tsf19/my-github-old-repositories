package com.tousif.NoConfigClass20;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 *  1. Add XmlAlternativeConfigClass.class in AnnotationConfigApplicationContext()
 *  2. Declare TextEditor and SpellChecker as @Component
 *  3. Declare XmlAlternativeConfigClass.class as @Configuration
 *  4. Add @ComponentScan(basePackages = { "com.tousif.NoConfigClass20" })
 * 
 *	If in AnnotationConfigApplicationContext() we add TextEditor.class & SpellChecker.class as follows -
 *	AnnotationConfigApplicationContext(TextEditor.class, SpellChecker.class)
 *	Then no need of XmlAlternativeConfigClass.class
 *	and Declaring TextEditor and SpellChecker as @Component
 */

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(XmlAlternativeConfigClass.class);

		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
//		SpellChecker spellChecker = (SpellChecker) context.getBean("spellChecker");
		
//		textEditor.setSpellChecker(spellChecker);

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