package com.tousif.NoConfigClass20;

import org.springframework.stereotype.Component;

@Component
public class SpellChecker {

	public SpellChecker(){
		System.out.println("Inside SpellChecker constructor.." );
	}
	public void checkSpelling() {
		System.out.println("Inside checkSpelling.." );
	}

	public void spellCheckerInit() {
		System.out.println("Inside spellCheckerInit()..");
	}

	public void spellCheckerCleanup() {
		System.out.println("Inside spellCheckerCleanup()..");
	}

}
