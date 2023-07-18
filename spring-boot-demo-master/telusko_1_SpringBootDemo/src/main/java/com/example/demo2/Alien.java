package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	
	private int alienId;
	private String alienName;
	private String alienTechnology;
	
	@Autowired	//3. Make this as an Autowired to connect this Alien.Laptop to Laptop.class
	@Qualifier("lappy") //6. Search by name "lappy", not by type "laptop"
	private Laptop laptop; //2. Creating Laptop inside Alien
	
//	4.1 @Autowired by-default search by-type, not search by-name
//	4.2 Default name of object created by SpringContainer via @Components is DE-CAPITALIZED "laptop","alien" 
	
//	5. We can also make it to search by-name, for that we need to use one more extra annotation i.e. @Qualifier
	
	public Alien() {
		super();
		System.out.println("\"Alien Object Ctreated\"");
	}
	public int getAlienId() {
		return alienId;
	}
	public void setAlienId(int alienId) {
		this.alienId = alienId;
	}
	public String getAlienName() {
		return alienName;
	}
	public void setAlienName(String alienName) {
		this.alienName = alienName;
	}
	public String getAlienTechnology() {
		return alienTechnology;
	}
	public void setAlienTechnology(String alienTechnology) {
		this.alienTechnology = alienTechnology;
	}

	public void show() {
		
		System.out.println("In Alien.show()");
		laptop.compile();
		
	}
	
}
