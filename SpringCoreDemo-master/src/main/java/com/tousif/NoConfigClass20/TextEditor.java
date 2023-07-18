package com.tousif.NoConfigClass20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

	@Autowired
	private SpellChecker spellChecker;
	
	@Value("General Text Editor")
	private String name;

	public TextEditor() {
		System.out.println("Inside TextEditor constructor..");
	}

	
//	public void setSpellChecker(SpellChecker spellChecker) {
//		System.out.println("Inside setSpellChecker()..");
//		this.spellChecker = spellChecker;
//	}


	public void spellCheck() {
		System.out.println("Inside spellCheck.." );
		System.out.println("Editor Name is : "+name);
		spellChecker.checkSpelling();
	}

}
