package com.tousif.HibernateMappingRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        System.out.println( "Hello World!" );
        
        Laptop laptop = new Laptop();
        
        laptop.setLid(1);
        laptop.setLname("Dell1");
        
        
        Student student = new Student();
        
        student.setRollno(101);
        student.setName("Student1");
        student.setMarks(10);
        
        
        student.getLaptop().add(laptop); //(After Ref.2) Student Knows about Laptop, and One Student has many Laptops.

        laptop.getStudent().add(student); //(After Ref.5) Laptop Knows about Students, and One Laptop has many Students.
        
        
        
        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = config.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        
//      Transaction txn = session.beginTransaction();
        session.beginTransaction();
        
        session.save(laptop);
        session.save(student);
        
//      txn.commit();
        session.getTransaction().commit();
        
        
        
    }
}
