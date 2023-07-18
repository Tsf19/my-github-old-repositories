package com.tousif.AutowiredOnSetter14;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

	private SpellChecker spellChecker;
	private String name;

	
	@Autowired
	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Inside setSpellChecker.." );
		this.spellChecker = spellChecker;
	}
	public SpellChecker getSpellChecker() {
		System.out.println("Inside getSpellChecker.." );
		return spellChecker;
	}

	public void setName(String name) {
		System.out.println("Inside setName.." );
		this.name = name;
	}
	public String getName() {
		System.out.println("Inside getName.." );
		return name;
	}
	
	
	public void spellCheck() {
		System.out.println("Inside spellCheck.." );
		System.out.println("Editor Name is : "+name);
		spellChecker.checkSpelling();
	}

}
