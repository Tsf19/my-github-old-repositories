package com.EmbededH2DataBaseExample.model2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	
	@Id
	private int alienId;
	private String alienName;
	
	
	
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
	
	public void show() {
		System.out.println("In Alien.show()");
	}
	@Override
	public String toString() {
		return "Alien [alienId=" + alienId + ", alienName=" + alienName + "]";
	}
	
}

