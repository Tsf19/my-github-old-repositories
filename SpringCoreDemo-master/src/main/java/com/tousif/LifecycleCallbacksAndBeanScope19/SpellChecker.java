package com.tousif.LifecycleCallbacksAndBeanScope19;

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
