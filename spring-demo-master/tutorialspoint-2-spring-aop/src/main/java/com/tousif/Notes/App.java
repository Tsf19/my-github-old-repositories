package com.tousif.Notes;

/**
 * @author Tousif
 *
 */

/**
 * @ASPECT_ORIENTED_PROGRAMMING (AOP) :
 *
 ** Aspect-Oriented Programming entails breaking down program logic
 *  into distinct parts called so-called concerns.
 *
 ** The functions that span multiple points of an application are called cross-cutting concerns
 *  and these cross-cutting concerns are conceptually separate from the application's business logic.
 *  
 ** Examples of aspects : logging, auditing, declarative transactions, security, caching, etc.
 * 
 ** AOP helps you decouple cross-cutting concerns from the objects that they affect.
 *  AOP is like triggers in programming languages such as Perl, .NET, Java, and others.
 *  
 ** Spring AOP module provides interceptors to intercept an application.
 *  For example, when a method is executed,
 *  you can add extra functionality before or after the method execution.
 * 
 * 
 * @AOP_TERMINOLOGIES 
 * 
 ** @ASPECT
 *** This is a module which has a set of APIs providing cross-cutting requirements.
 *   For example, a logging module would be called AOP aspect for logging.
 *   An application can have any number of aspects depending on the requirement.
 *
 ** @JOIN_POINT
 *** This represents a point in your application where you can plug-in the AOP aspect.
 *   You can also say, it is the actual place in the application
 *   where an action will be taken using Spring AOP framework.
 *
 ** @ADVICE
 *** This is the actual action to be taken either before or after the method execution.
 *   This is an actual piece of code that is invoked
 *   during the program execution by Spring AOP framework.
 *
 ** @POINTCUT
 *** This is a set of one or more join points where an advice should be executed.
 *   You can specify pointcuts using expressions or patterns.
 *
 *
 ** @INTRODUCTION
 *** An introduction allows you to add new methods or attributes to the existing classes.
 *
 ** @TARGET_OBJECT
 *** The object being advised by one or more aspects.
 *   This object will always be a proxied object, also referred to as the advised object.
 *
 ** @WEAVING
 *** Weaving is the process of linking aspects with other application types or objects
 *   to create an advised object. This can be done at compile time, load time, or at runtime.
 * 
 *   
 * @TYPES_OF_ADVICE
 * 
 ** @BEFORE
 *** Run advice before the a method execution.
 *
 ** @AFTER
 *** Run advice after the method execution, regardless of its outcome.
 *
 ** @AFTER_RETURNING
 *** Run advice after the a method execution only if method completes successfully.
 *
 ** @AFTER_THROWING
 *** Run advice after the a method execution only if method exits by throwing an exception.
 *
 ** @AROUND
 *** Run advice before and after the advised method is invoked.
 *
 *@see https://www.tutorialspoint.com/spring/aop_with_spring.htm
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
