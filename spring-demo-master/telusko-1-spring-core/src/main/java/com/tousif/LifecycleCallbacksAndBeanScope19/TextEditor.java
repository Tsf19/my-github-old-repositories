package com.tousif.LifecycleCallbacksAndBeanScope19;

import org.springframework.beans.factory.annotation.Value;

public class TextEditor {

	private SpellChecker spellChecker;
	
	@Value("General Text Editor")
	private String name;

	public TextEditor() {
		System.out.println("Inside TextEditor constructor..");
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

//	@Value("General Text Editor")	//Use it Either in PropertyName or in SetterMethod
	public void setName(String name) {
		System.out.println("Inside setName.." );
		this.name = name;
	}

	public void spellCheck() {
		System.out.println("Inside spellCheck.." );
		System.out.println("Editor Name is : "+name);
		spellChecker.checkSpelling();
	}

}
