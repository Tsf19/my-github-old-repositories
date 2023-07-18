package com.tousif._2_1_AutowiredDemo;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	public void drive() {
		System.out.println("Inside Bike");
	}
}
