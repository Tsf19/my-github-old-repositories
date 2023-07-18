# spring-demo

# IOC - Inversion of Control : “Don’t call us, we’ll call you” 
IOC is above and beyond Spring. It is a Object oriented design principle which reduces dependency and increases modularity and make program extensible. 
As Martin Fowler says inversion of control is the principle where the control flow of a program is inverted: instead of the programmer controlling the flow of a program, the external sources (framework, services, other components) take control of it. 
In Spring IOC, IOC also know as Depedency Injection. IOC is a technic that allows object configuration to be moved out of the code and into a configuration file. 

In Spring org.springframework.beans and org.springframework.contextcontains the implementation of IOC called Spring IOC Container. The interface org.springframework.context.ApplicationContext represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the objects (In Spring the objects are Beans).
