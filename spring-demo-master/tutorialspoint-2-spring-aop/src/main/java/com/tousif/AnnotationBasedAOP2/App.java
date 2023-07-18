package com.tousif.AnnotationBasedAOP2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tousif
 *
 */

/**
 * The @AspectJ support is enabled by including the following element inside your XML Schema-based configuration file.
 * <aop:aspectj-autoproxy/>
 * 
 * Aspects classes are like any other normal bean and may have methods and fields just like any other class,
 * except that they will be annotated with @Aspect
 *
 * A pointcut helps in determining the join points (ie methods) of interest to be executed
 * with different advices.
 * While working with @AspectJ-based configuration,
 * pointcut declaration has two parts −
 * 
 **  A pointcut expression that determines exactly which method executions we are interested in.
 *
 **  A pointcut signature comprising a name and any number of parameters.
 *   The actual body of the method is irrelevant and in fact should be empty.
 * 
 */

public class App {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("AnnotationBasedAOP2.xml");
      
      Student student = (Student) context.getBean("student");
      student.getName();
      student.getAge();
      student.printThrowException();	
   }
}
/**
 * @OUTPUT : 
 * Going to setup student profile.
 * Name : Tousif
 * Student profile has been setup.
 * Returning:Tousif
 * Going to setup student profile.
 * Age : 24
 * Student profile has been setup.
 * Returning:24
 * Going to setup student profile.

 * Exception in thread "main" java.lang.IllegalArgumentException

 * Exception raised
 * Student profile has been setup.
 * There has been an exception: java.lang.IllegalArgumentException
*/