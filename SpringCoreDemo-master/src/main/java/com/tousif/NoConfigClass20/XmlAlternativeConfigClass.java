/**
 * 
 */
package com.tousif.NoConfigClass20;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tousif
 *
 */

@Configuration
@ComponentScan(basePackages = { "com.tousif.NoConfigClass20" })
public class XmlAlternativeConfigClass {
	
//	@Bean
//	public TextEditor textEditor() {
//		return new TextEditor();
//	}
//	
//	@Bean
//	public SpellChecker spellChecker() {
//		return new SpellChecker();
//	}

}
