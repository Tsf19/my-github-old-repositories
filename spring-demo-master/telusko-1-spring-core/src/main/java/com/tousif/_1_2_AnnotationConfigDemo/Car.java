package com.tousif._1_2_AnnotationConfigDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

	@Autowired
	private Tyre tyre;
	
	public Tyre getTyre() {
		System.out.println("Inside getTyre() in Car.class");
		return tyre;
	}
	public void setTyre(Tyre tyre) {
		System.out.println("Inside setTyre() in Car.class");
		this.tyre = tyre;
	}

	public void drive() {
		System.out.println("Inside drive() in Car.class");
	}
	
}
