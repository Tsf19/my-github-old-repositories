package com.tousif.crud_demo;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SQLDemo {



	public static void main( String[] args ) {

//		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
//		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
//		SessionFactory sf = config.buildSessionFactory(reg);
//		Session session = sf.openSession();
		
		//LONG WAY....
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Student.class);
		
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		
		ServiceRegistry reg = srb.applySettings(config.getProperties()).buildServiceRegistry();
		
		
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();

		session.beginTransaction();
		System.out.println("Transaction Started");

		//		1. CREATING TABLE

		//		Random r = new Random();
		//		
		//		for(int i=1; i<=10; i++) {
		//			Student s = new Student();
		//			s.setRollno(i);
		//			s.setName("Name"+i);
		//			s.setMarks(r.nextInt(100));
		//			session.save(s);
		//		}


		//	USING SQL
		
//		1.PRINTING ENTIRE TABLE
		
//		SQLQuery query = session.createSQLQuery("select * from Student where student_marks>60"); //Normal SQL Query
//		//USE student_marks not marks, as SQL takes data from Table not Class
//
//		query.addEntity(Student.class); //To Specify what type of values we are getting, we are getting Student object so that we can type cast
//		
//		List<Student> students = query.list();
//		
//		 for(Student s : students) {
//			 System.out.println(s);
//		 }


		
//		2.PRINTING SPECIFIC COLUMN
		
//		Suppose we want to print just name and marks, 
		SQLQuery query = session.createSQLQuery("select student_name, student_marks from Student where student_marks>60");
		
//		When fetching name and marks, we have to specify that we are getting two things, and fetch it by means of key value pair
//		<student_name, name> & <student_marks, marks>
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); //It will convert output into map format
		
		List students = query.list();
		
		 for(Object o : students) {
			 Map m = (Map)o;
			 System.out.println(m.get("student_name") + " " + m.get("student_marks"));
		 }
		

		


























		session.getTransaction().commit();
		System.out.println("Transaction Completed");




	}

}
