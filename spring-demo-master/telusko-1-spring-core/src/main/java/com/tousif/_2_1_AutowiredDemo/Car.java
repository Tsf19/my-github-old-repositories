package com.tousif._2_1_AutowiredDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

//	private Tyre tyre = new Tyre(); //Remove Object
	
	@Autowired
	private Tyre tyre; //Now we are not getting Object of Tyre inside Car class, to get it's object we declare it as autowired
	
	public Tyre getTyre() {
		return tyre;
	}
	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	public void drive() {
		System.out.println("Inside Car" + tyre);
	}
	
}
