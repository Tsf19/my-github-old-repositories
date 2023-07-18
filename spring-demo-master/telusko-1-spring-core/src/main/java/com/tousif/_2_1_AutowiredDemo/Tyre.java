package com.tousif._2_1_AutowiredDemo;

import org.springframework.stereotype.Component;

@Component //Without Using XML we can get Same OutPut
public class Tyre {

	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return " Tyre Brand is :"+brand;
	}
	
	
	
}
