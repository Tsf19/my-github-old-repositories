package com.tousif.AutowiredOnProperties15;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

	@Autowired	//No Setter is Required now
	private SpellChecker spellChecker;
	private String name;

	
//	public void setSpellChecker(SpellChecker spellChecker) {
//		System.out.println("Inside setSpellChecker.." );
//		this.spellChecker = spellChecker;
//	}

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
