package com.tousif.ConstructorBasedDependencyInjection8;

import java.util.Date;

public class DateProvider {
	
	Date date;
	
	public DateProvider() {
		System.out.println("Inside DateProvider Constructor");
		this.date = new Date();
	}

}
