package com.tousif._2_2_AutowiredAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//5.
//This Class is responsible for configuration so we need to specify an annotation @Configuration
//As soon as we specify @Configuration, this class is responsible for to give us those objects
@Configuration
public class AppConfig {
	
//	In XML we used to do :
//<bean>
//	<bean id="phone" class="Samsung"/>
//</beans> 

	@Bean //We need to specify that this is a bean.
	public Samsung getPhone() {
		
		return new Samsung();
	}
	
//	12. So that "MobileProcessor cpu;" will be initialized as an object of Snapdragon
	@Bean
	public MobileProcessor getProcessor() {
		return new Snapdragon();
	}
	
}
