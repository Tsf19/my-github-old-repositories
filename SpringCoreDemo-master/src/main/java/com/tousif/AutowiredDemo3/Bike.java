package com.tousif.AutowiredDemo3;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	public void drive() {
		System.out.println("Inside Bike");
	}
}
