package com.tousif._2_3_AutowiredWithoutBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


	public static void main(String[] args) {

		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		Samsung samsung = factory.getBean(Samsung.class);
		samsung.config();
	}

}
