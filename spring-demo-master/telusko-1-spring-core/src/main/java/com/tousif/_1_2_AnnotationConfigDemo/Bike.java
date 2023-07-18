package com.tousif._1_2_AnnotationConfigDemo;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	public void drive() {
		System.out.println("Inside drive() in Bike.class");
	}
}
