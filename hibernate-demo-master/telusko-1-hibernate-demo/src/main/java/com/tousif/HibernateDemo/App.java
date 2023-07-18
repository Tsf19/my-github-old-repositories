package com.tousif.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        PojoDemo obj1 = new PojoDemo();
//        PojoDemo obj1 = null; : No Need to Create Object while Fetching Data
        
        
        //NOT STORING ALL THE VALUE OF AN OBJECT, ONLY STORING LAST ONE
        
//        obj1.setId(1);
//        obj1.setFirstName("Hibernate1");
//        obj1.setMiddleName("Middle1");
//        obj1.setLastName("Demo1");
//        
        obj1.setId(7);
        obj1.setFirstName("Hibernate7");
        obj1.setMiddleName("Middle7");
        obj1.setLastName("Demo7");
        
        Address address = new Address(); //COMPOSITE ATTRIBUTE
        address.setStreet("street7");
        address.setCity("city7");
        address.setState("state7");
        
        obj1.setAddress(address); //Setting Composite Attribute
        
        
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(PojoDemo.class);
        // configure() method used because just Configuration() class won't take you to the hibernate.cfg.xml file
        /* addAnnotatedClass(PojoDemo.class) : To Specify that you are working with PojoDemo and that's an Entity and
          we are Using Annotations. */
        
        
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        //We are getting Object of Registry, 
        
        
        
        //2.SessionFactory is also an Interface
        SessionFactory sf = config.buildSessionFactory(reg);
        //buildSessionFactory() is deprecated , so after Hibernate 4.1 we need to use ServiceRegistry Interface
        
        
        
        // 1.Session is not a class, it's an Interface, so we need to use class which Implements Session.
        Session session = sf.openSession();
        // openSession() gives object of session		
        		

        
        Transaction txn = session.beginTransaction(); // FollowingACID Property
        

        
        session.save(obj1); //SAVING to DataBase
        
        
        //TWO METHODS TO FETCH DATA : 1.get()	2.load()
        obj1 = (PojoDemo)session.get(PojoDemo.class, 7); //FETCHING The Data Where Id is 6
        
        txn.commit();  // FollowingACID Property
        
        
        
        System.out.println( "I'm in TestLine#" );
        
        System.out.println(obj1);
    }
}
