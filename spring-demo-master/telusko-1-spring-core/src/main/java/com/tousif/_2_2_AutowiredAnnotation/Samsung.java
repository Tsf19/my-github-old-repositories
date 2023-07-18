package com.tousif._2_2_AutowiredAnnotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Samsung {


//	10.
//	Adding Mobile Processor in Phone
	
	@Autowired //	13.In order to connect "MobileProcessor cpu;" with "bean" in "AppConfig",
	MobileProcessor cpu; //By default @Autowired doesn't check name, it checks type
	
	public MobileProcessor getCpu() {
		return cpu;
	}
	public void setCpu(MobileProcessor cpu) {
		this.cpu = cpu;
	}

	
//	BEFORE 10
//	public void config() {
//		System.out.println("OctaCore, 4GB RAM, 64GB Storage, 12MP Camera");
//
//	}
	
	
//	11. AFTER 10
	public void config() {
	
		System.out.println("OctaCore, 4GB RAM, 64GB Storage, 12MP Camera");
		cpu.process(); //Along with Configuration, also printing CPU

	}

}
