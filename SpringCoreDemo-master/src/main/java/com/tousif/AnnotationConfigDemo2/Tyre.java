package com.tousif.AnnotationConfigDemo2;

import org.springframework.stereotype.Component;

@Component
public class Tyre {

	private String brand;

	public String getBrand() {
		System.out.println("Inside getBrand() in Tyre.class");
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("Inside setBrand() in Tyre.class");
		this.brand = brand;
	}

	@Override
	public String toString() {
		return " Tyre["+brand+"]";
	}
	
	
	
}
