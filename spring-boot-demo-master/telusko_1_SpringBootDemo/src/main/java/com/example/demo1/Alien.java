package com.example.demo1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component //5.1 Going for Prototype Scope
@Component() //5.2
@Scope(value = "prototype") //5.3
public class Alien {
	
	private int alienId;
	private String alienName;
	private String alienTechnology;
	
	
	
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
		
	}
	
}
