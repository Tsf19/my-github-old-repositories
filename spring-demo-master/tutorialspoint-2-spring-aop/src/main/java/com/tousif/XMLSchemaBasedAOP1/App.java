package com.tousif.XMLSchemaBasedAOP1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 * You will also need the following AspectJ libraries on the CLASSPATH of your application :
 ** aspectjweaver
 *
 *
 * An aspect is declared using the <aop:aspect> element,
 * and the backing bean is referenced using the ref attribute
 * 
 * A pointcut helps in determining the join points (ie methods) of interest
 * to be executed with different advices.
 * 
 * You can declare any of the five advices inside an <aop:aspect> using the <aop:{ADVICE NAME}> element
 */

public class App {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("XMLSchemaBasedAOP1.xml");
      
      Student student = (Student) context.getBean("student");
      student.getName();
      student.getAge();
//      student.printThrowException();	
   }
}