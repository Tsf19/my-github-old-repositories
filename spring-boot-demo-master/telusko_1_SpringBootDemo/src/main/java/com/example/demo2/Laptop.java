package com.example.demo2;

import org.springframework.stereotype.Component;

//1. Creating Laptop POJO
//@Component //7.1
@Component("lappy") //7.2 Changing Laptop object's default name "laptop" to "lappy" 
public class Laptop {
	
	private int laptopId;
	private String laptopBrand;
	
	
	public Laptop() {
		super();
		System.out.println("\"Laptop Object Created\"");
	}
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopBrand() {
		return laptopBrand;
	}
	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}
	
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopBrand=" + laptopBrand + "]";
	}

	public void compile() {
		System.out.println("In Laptop.compile()");
	}
}
