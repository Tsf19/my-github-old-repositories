package com.tousif.HibernateFetchLazyEager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alien {
	
	@Id
	private int aid;
	private String aname;
	
//	@OneToMany(mappedBy="alien")
//	4.
	@OneToMany(mappedBy="alien", fetch=FetchType.EAGER) //By Default FetchType is Lazy
	private List<Laptop> laps = new ArrayList<Laptop>();

	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}

	public List<Laptop> getLaps() {
		return laps;
	}
	public void setLaps(List<Laptop> laps) {
		this.laps = laps;
	}
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", laps=" + laps + "]";
	}
	
	
	
	
}
