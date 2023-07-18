package com.tousif.ConstructorBasedDependencyInjection8;

import java.util.Date;

public class TextEditor {
	
	private Integer day;
	private Date date;
	
	public TextEditor(Integer day, DateProvider dateProvider) {
	      System.out.println("Inside TextEditor constructor.." );
	      this.day = day;
	      this.date = dateProvider.date;
	}
	
	public void printDayDate() {
		System.out.println("Day is : "+day+"\nDate is :"+date);
	}

	
	
}
