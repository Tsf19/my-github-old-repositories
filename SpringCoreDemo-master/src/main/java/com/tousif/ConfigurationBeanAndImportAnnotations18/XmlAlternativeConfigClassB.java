package com.tousif.ConfigurationBeanAndImportAnnotations18;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Tousif
 *
 */

@Configuration
@Import(XmlAlternativeConfigClassA.class)
public class XmlAlternativeConfigClassB {
	
	@Bean
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}

}
