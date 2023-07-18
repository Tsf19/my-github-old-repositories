package com.tousif;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/*
 * // 1.Create this Config Class(Substitute of tousifservlet-servlet.xml)
 * 
 * @Configuration //2.
 * 
 * @ComponentScan({"com.tousif"}) //3.Can Add Multiple Packages using Commas
 * public class tousifServletServletXMLAlternative {
 * 
 * // 11.InternalResourceViewResolver is responsible for View name// 12. Let's
 * move display.jsp to WEB-INF from webapp to Hide that file so that no one can
 * access it directly
 * 
 * @Bean // public InternalResourceViewResolver viewResolver() {
 * 
 * InternalResourceViewResolver resolver = new InternalResourceViewResolver();
 * 
 * resolver.setPrefix("/WEB-INF/"); resolver.setSuffix(".jsp"); //In future if
 * we move to jsf, we just need to change it here only
 * 
 * return resolver;
 * 
 * }
 * 
 * }
 */

//13. OR

@Configuration
@EnableWebMvc
@ComponentScan({"com.tousif"})
public class tousifServletServletXMLAlternative extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/"); resolver.setSuffix(".jsp");
		return resolver;
	}

}