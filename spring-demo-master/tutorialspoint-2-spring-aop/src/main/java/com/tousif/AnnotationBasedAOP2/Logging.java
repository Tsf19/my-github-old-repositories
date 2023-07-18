package com.tousif.AnnotationBasedAOP2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
/**
 * @author Tousif
 *
 */
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;



@Aspect
public class Logging {
	
	
   /** Following is the definition for a pointcut to select
    *  all the methods available. So advice will be called
    *  for all the methods.
    */
	
//   @Pointcut("execution(* com.tousif.AnnotationBasedAOP2.*.*(..))")
	/**
	 * The above defined <aop:pointcut> selects all the methods defined
	 * under the package com.tutorialspoint. Let us suppose, you want to
	 * execute your advice before or after a particular method,
	 * you can define your pointcut to narrow down your execution by replacing stars (*)
	 * in pointcut definition with the actual class and method names. 
	 * 
	 * */
	
	@Pointcut("execution(* com.tousif.AnnotationBasedAOP2.Student.getName(..))")
   private void selectAll(){}

   /** 
    * This is the method which I would like to execute
    * before a selected method execution.
    */
   @Before("selectAll()")
   public void beforeAdvice(){
      System.out.println("Going to setup student profile.");
   }

   /** 
    * This is the method which I would like to execute
    * after a selected method execution.
    */
   @After("selectAll()")
   public void afterAdvice(){
      System.out.println("Student profile has been setup.");
   }

   /** 
    * This is the method which I would like to execute
    * when any method returns.
    */
   @AfterReturning(pointcut = "selectAll()", returning = "retVal")
   public void afterReturningAdvice(Object retVal){
      System.out.println("Returning:" + retVal.toString() );
   }

   /**
    * This is the method which I would like to execute
    * if there is an exception raised by any method.
    */
   @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
   public void AfterThrowingAdvice(IllegalArgumentException ex){
      System.out.println("There has been an exception: " + ex.toString());   
   }
   
}