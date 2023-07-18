package com.tousif.HibernateFetchLazyEager;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
//    	Alien al1 = new Alien();
//    	Alien al2 = new Alien();
//    	Alien al3 = new Alien();
//    	
//    	Laptop lap1 = new Laptop();
//    	Laptop lap2 = new Laptop();
//    	Laptop lap3 = new Laptop();
//    	Laptop lap4 = new Laptop();
//    	Laptop lap5 = new Laptop();
//    	
//    	lap1.setLid(101);
//    	lap1.setBrand("Dell");
//    	lap1.setPrice(1000);
//    	lap1.setAlien(al1); //    STORING FOREIGN KEY
//
////    	lap2.setLid(102);		//AUTO-INCREMENT
//    	lap2.setBrand("Apple");
//    	lap2.setPrice(2000);
//    	lap2.setAlien(al3);
//    	
////    	lap3.setLid(103);		//AUTO-INCREMENT
//    	lap3.setBrand("Asus");
//    	lap3.setPrice(800);
//    	lap3.setAlien(al1);
//    	
////    	lap4.setLid(104);		//AUTO-INCREMENT
//    	lap4.setBrand("Acer");
//    	lap4.setPrice(1500);
//    	lap4.setAlien(al3);
//    	
////    	lap5.setLid(105);		//AUTO-INCREMENT
//    	lap5.setBrand("Samsung");
//    	lap5.setPrice(1400);
//    	lap5.setAlien(al1);
//
//    	
//    	al1.setAid(10);
//    	al1.setAname("Navin");
//    	
//    	al2.setAid(11);
//    	al2.setAname("Rahul");
//    	
//    	al3.setAid(12);
//    	al3.setAname("Mayank");
//    	
//    	al1.getLaps().add(lap1);
//    	al1.getLaps().add(lap3);
//    	al1.getLaps().add(lap5);
//    	
//    	al3.getLaps().add(lap2);
//    	al3.getLaps().add(lap4);
    	
    	
    	Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	SessionFactory sf = config.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	System.out.println("Transaction Started");
    	
//    	session.save(al1);
//    	session.save(al2);
//    	session.save(al3);
//    	
//    	session.save(lap1);
//    	session.save(lap2);
//    	session.save(lap3);
//    	session.save(lap4);
//    	session.save(lap5);
    	
//    	1. FETCH LAZY : Not Fetching Collection(Laptops Details), Not Firing Query for Laptop.
    	Alien al1 = (Alien)session.get(Alien.class, 10);
    
//    	2. The Moment we are explicitly printing Laptop Details, Hibernate is also firing Query for Laptop
//    	It is Firing Query for Laptops only when you want it.
//    	It is Firing TWO Quaries, 1. for Alien	2. for Laptop

//    	System.out.println(al1.getAname());
//    	Collection<Laptop> laps = al1.getLaps();
//    	
//    	for(Laptop l : laps) {
//    		System.out.println(l.toString());
//
//    	}
    	
//    	3. Making Fetch Type EAGER (Ref.4@ Alien.java)

//    	5.
//    	It is Not Firing TWO Different Quaries for Alie for Laptop, It will Fire Only One Quary for BOTH
//    	Using LEFT OUTER JOIN
    	session.getTransaction().commit();
    	System.out.println("Transaction Completed");
    }
}
