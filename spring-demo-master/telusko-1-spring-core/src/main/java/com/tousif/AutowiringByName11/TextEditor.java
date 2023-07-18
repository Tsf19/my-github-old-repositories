package com.tousif.AutowiringByName11;

public class TextEditor {
	
	private SpellChecker spellChecker;
	private String name;
	
	public SpellChecker getSpellChecker() {
		System.out.println("Inside getSpellChecker()");
		return spellChecker;
	}
	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Inside setSpellChecker()");
		this.spellChecker = spellChecker;
	}

	public String getName() {
		System.out.println("Inside getName()");
		return name;
	}
	public void setName(String name) {
		System.out.println("Inside setName()");
		this.name = name;
	}
	
	public void spellCheck() {
		System.out.println("Text Editor Name : "+name);
		spellChecker.checkSpelling();
   }
	
}
