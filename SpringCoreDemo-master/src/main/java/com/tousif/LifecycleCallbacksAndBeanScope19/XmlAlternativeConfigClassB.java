package com.tousif.LifecycleCallbacksAndBeanScope19;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @author Tousif
 *
 */

@Configuration
@Import(XmlAlternativeConfigClassA.class)
public class XmlAlternativeConfigClassB {
	
	@Bean(initMethod = "spellCheckerInit", destroyMethod = "spellCheckerCleanup" )
//	@Scope("prototype")
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}

}
