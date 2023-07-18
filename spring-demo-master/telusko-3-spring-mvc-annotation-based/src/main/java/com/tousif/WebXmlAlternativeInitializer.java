package com.tousif;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//4.Create This class as an Alternative of Configuration in Web.Xml
//5. MUST EXTEND - org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

public class WebXmlAlternativeInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
//		return null; //14.
		return new Class[] {tousifServletServletXMLAlternative.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {tousifServletServletXMLAlternative.class}; //6. Instead of tousifservlet-servlet.xml
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};	//7. <url-pattern>/</url-pattern> as in web.xml
	}

}
