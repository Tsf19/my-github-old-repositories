package com.tousif._2_3_AutowiredWithoutBean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component //3. We need object of Snapdragon, so make it also as a Component
//@Primary //10. So to resolve the issue occured in 9, we can define this bean as "primary", so no ambiguity, by default it will consider this bean 
public class Snapdragon implements MobileProcessor {

	public void process() {

		System.out.println("Snapdragon CPU");
		
	}

}
