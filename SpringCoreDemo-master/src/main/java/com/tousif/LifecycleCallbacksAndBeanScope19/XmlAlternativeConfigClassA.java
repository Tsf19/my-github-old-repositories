package com.tousif.LifecycleCallbacksAndBeanScope19;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tousif
 *
 */

@Configuration
public class XmlAlternativeConfigClassA {
	
	@Bean
	public TextEditor textEditor() {
		return new TextEditor();
	}
	
}
