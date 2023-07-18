/**
 * 
 */
package com.tousif.ConfigurationAndBean17;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tousif
 *
 */

@Configuration
//@ComponentScan(basePackages = { "com.tousif.ConfigurationAndBean17" })
public class XmlAlternativeConfigClass {
	
	@Bean
	public TextEditor textEditor() {
		return new TextEditor();
	}
	
	@Bean
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}

	/**
	 * The above code will be equivalent to the following XML configuration −
	 * 
	 * <beans>
	 * 		<bean id = "textEditor" class = "com.tousif.ConfigurationAndBean17.TextEditor" />
	 * </beans>
	 * 
	 * Here, the method name is annotated with @Bean works as bean ID and it creates and returns the actual bean.
	 * Your configuration class can have a declaration for more than one @Bean.
	 * Once your configuration classes are defined,
	 * you can load and provide them to Spring container using AnnotationConfigApplicationContext
	 *
	 */
}
