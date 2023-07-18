package com.tousif._1_1_XmlConfigDemo;


public class Tyre {
	
	public Tyre(String brand) {		//CONSTRUCTOR_INJECTION
		super();
		this.brand = brand;
	}

	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {	//Property in XML is using this Setter Method to Assign Value
		this.brand = brand;					// Hence it is called as SETTER_INJECTION
	}

	@Override
	public String toString() {
		return "Tyre [brand=" + brand + "]";
	}
	
	
	
}
