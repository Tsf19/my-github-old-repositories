package com.tousif.ConstructorBasedDependencyInjection7;

public class TextEditor {
	
	private SpellChecker spellChecker;
	private SpellCorrector spellCorrector;
	
	public TextEditor(SpellChecker spellChecker, SpellCorrector spellCorrector) {
	      System.out.println("Inside TextEditor constructor.." );
	      this.spellChecker = spellChecker;
	      this.spellCorrector = spellCorrector;
	}

	   public void spellCheck() {
		      spellChecker.checkSpelling();
		   }
	   
	   public void spellCorrect() {
		   spellCorrector.correctSpelling();
	   }
	
}
