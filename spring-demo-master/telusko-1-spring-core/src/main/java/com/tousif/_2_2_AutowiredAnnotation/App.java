package com.tousif._2_2_AutowiredAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {

		
//		1.
//		To call Samsung.config(), we need to create Object of Samsung
//		
//		Samsung samung = new Samsung();
//		samung.config();
//		
//		But this is not dependency injection, we need to inject this object using spring
		
//		2.
//		We use this when using XML Based Configuration
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("XmlBasedConfig.xml");
		
//		ApplicationContext is an Interface so to Implement it we have to use ClassPathXmlApplicationContext.
		
//		3.
//		In Order to inject object of Samsung, we need to can ask our factory which is AppliacationContext
//		we need to create object of AppliacationContext
//		In Order to create object of AppliacationContext which is an interface,
//		we need to use Class - AnnotationConfigApplicationContext
		
//		ApplicationContext factory = new AnnotationConfigApplicationContext();
		
//		Samsung samsung = factory.getBean(Samsung.class); //Specify class of which you want object
//		samsung.config(); //ERROR
		
//		4.
//		In XML Based Configuration, we specified XmlBasedConfig.xml, like
//
//		<bean>
//			<bean id="phone" class="Samsung"/>
//		</beans>
//		
//		This is what we do when working with XML,
//		In order to work with AnnotationBasedConfiguration we need to create a class who is responsible for above <bean>
		
//		6.
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
//		This factory need to know about which class you are working with
		Samsung samsung = factory.getBean(Samsung.class);
		samsung.config(); //ERROR --> Specify @Bean in AppConfig.class
		
		
//		7.
//		Now I want one more object i.e. CPU
		
//		<bean>
//		<bean id="phone" class="Samsung"/>
//		<bean id="cpu" class="Snapdragon"/>
//		</beans>
		
		
	}

}
