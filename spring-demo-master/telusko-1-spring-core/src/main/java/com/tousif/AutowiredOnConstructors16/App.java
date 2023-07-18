package com.tousif.AutowiredOnConstructors16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 * #AutowiredOnConstructors
 * You can apply @Autowired to constructors as well.
 * A constructor @Autowired annotation indicates that the constructor should be autowired when creating the bean,
 * even if no <constructor-arg> elements are used while configuring the bean in XML file.
 * 
 * @see https://www.tutorialspoint.com/spring/spring_autowired_annotation.htm
 */

public class App {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("AutowiredOnConstructors16.xml");
		
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck();
		
	}
}

/**
 * @Autowired with (required = false) option
 * By default, the @Autowired annotation implies the dependency is required similar to @Required annotation,
 * however, you can turn off the default behavior by using (required=false) option with @Autowired.

 * The following example will work even if you do not pass any value for age property
 * but still it will demand for name property.
 * 
 * @see https://www.tutorialspoint.com/spring/spring_autowired_annotation.htm
 */

/**
 * 	public class Student { 
 * 		private Integer age;
 * 		private String name;
 * 
 * 		@Autowired(required=false)
 * 		public void setAge(Integer age) { 
 * 			this.age = age;
 * 		}
 * 		public Integer getAge() { 
 * 		return age;
 * 		}
 * 
 * 		@Autowired
 * 		public void setName(String name) {
 * 			this.name = name;
 * 		}
 * 		public String getName() {
 * 			return name;
 * 		}
 * }
 * 
 */