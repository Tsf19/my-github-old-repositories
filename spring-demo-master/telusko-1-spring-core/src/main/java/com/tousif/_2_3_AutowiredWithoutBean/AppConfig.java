package com.tousif._2_3_AutowiredWithoutBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.tousif.AutowiredWithoutBean5") //4. Need to Define an Extra Annotation 
public class AppConfig {
	
	
//	5. @ComponentScan(basePackages="com.touif.AutowiredWithoutBean5")
//	ComponentScan will search by "Type"
//	Need to define BasePackages so that it will scan classes/components from this Packages,
//	If multiple packages, then define multiple packages using ",(commas)"
	
	
//	1.Commenting Beans -- It should run without this bean also	
//	@Bean 
//	public Samsung getPhone() {
//		
//		return new Samsung();
//	}
//	
//	@Bean
//	public MobileProcessor getProcessor() {
//		return new Snapdragon();
//	}
	
}
