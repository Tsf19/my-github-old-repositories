package com.tousif._2_3_AutowiredWithoutBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component //2. Every Class of which you need an Object, declare this as an @Component
//@Component //6. By Default name(bean id) of "Smasung" class will be "samsung"(Small "s")
// By-Default name will be Non-Qualified and De-Capitalized, bean-id(name) won't have an package-name
@Component("mySamsung") //7. Changing name from "samsung" to "mySamsung"
public class Samsung {

//	9. After creation of MediaTek, now conflict will arise --> NoUniqueBeanDefinationException
//	Because nowhere we have defined that what type of cpu we need(Snapdragon or MediaTek)
	
	@Autowired 
	@Qualifier("snapdragon") //OR @Qualifier("mediaTek")
	//11. Instead of using @Primary, we can use @Qualifier, @Qualifier("beanId OR defaultName") ,Give name of which you want Object
	MobileProcessor cpu;
	
	public MobileProcessor getCpu() {
		return cpu;
	}
	public void setCpu(MobileProcessor cpu) {
		this.cpu = cpu;
	}

	

	public void config() {
	
		System.out.println("OctaCore, 4GB RAM, 64GB Storage, 12MP Camera");
		cpu.process(); 

	}

}

