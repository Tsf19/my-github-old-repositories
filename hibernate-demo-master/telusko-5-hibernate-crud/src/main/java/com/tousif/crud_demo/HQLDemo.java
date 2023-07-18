package com.tousif.crud_demo;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HQLDemo 
{

	public static void main( String[] args ) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
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

		
		//	USING HQL
		
		
//		2. PRINTING LIST OF ALL STUDENTS
		
//		Query q = session.createQuery("select * from Student"); //ERROR
//		Query q = session.createQuery("select from Student"); //ERROR

		Query q = session.createQuery("from Student where marks>60");
		//USE marks not student_marks, as HQL takes data from Class not Table
		
		List<Student> student = q.list();
		
		 for(Student s : student) {
			 System.out.println(s);
		 }
		
		
		
//		 3.	PRINTING UNIQUE ROW
		
//		Query q = session.createQuery("from Student where rollno = 7");
//		Student student = (Student)q.uniqueResult();
//		System.out.println(student);
		
		
//		 4.	PRINTING SELECTED COLUMNS
		
//		Query q = session.createQuery("select name, marks from Student where rollno = 7"); //ERROR
//		Student student = (Student)q.uniqueResult();
//		System.out.println(student);
//		
//		ERROR : It will not return Student object, it will return Object because rollno is int, name is String and marks is int
//		We are getting more than one object(name,marks) therefore we need to create an Array of Object

		
		
//		 5.	PRINTING SELECTED COLUMNS
		
//		Query q = session.createQuery("select name, marks from Student where rollno = 7");
//		Object[] student = (Object[])q.uniqueResult();
//
////		for(Object o : student) {
////			System.out.println(o);
////		}
//		
		
////		OR
	
//		System.out.println(student[0]+" "+student[1]);

		
		
//		6. PRINTING LIST OF SELECTED COLUMNS
		
////		Query q = session.createQuery("select name, marks from Student where rollno<=7 AND marks>50"); //NO ERROR BUT
////		We should be very specific, marks cab be in other table also in cas of JOIN, so use ALIAS
//		Query q = session.createQuery("select name, marks from Student s where s.rollno<=7 AND s.marks>50");
//		
//		List<Object[]> students = (List<Object[]>)q.list();
//		
//		 for(Object[] s : students) {
//			 System.out.println(s[0]+" "+s[1]);
//		 }
		
		
		
//		7. PRINTING SUM OF MARKS
		
//		Query q = session.createQuery("select sum(marks) from Student s where s.rollno<=7 AND s.marks>50");
//		List students = (List)q.list();
//		
//		 for(Object s : students) {
//			 System.out.println(s);
//		 }
		 
//		OR
		
//  	Query q = session.createQuery("select sum(marks) from Student s where s.rollno<=7 AND s.marks>50");
//		Object totalMarks = (Object)q.uniqueResult();
//		System.out.println(totalMarks);
		 
//		OR
		
//		Query q = session.createQuery("select sum(marks) from Student s where s.rollno<=7 AND s.marks>50");
//		Long totalMarks = (Long)q.uniqueResult(); //Shouldn't use Integer instead of Long
//		System.out.println(totalMarks);
		
		
		
//		8. USING VARIABLE QUERY
		
		//USING CONCATINATION
//		int temp = 50;
//		Query q = session.createQuery("select sum(marks) from Student s where s.rollno<=7 AND s.marks>"+temp);
//		Long totalMarks = (Long)q.uniqueResult(); //Shouldn't use Integer instead of Long
//		System.out.println(totalMarks);
		
		//OR
		
		
		//BY SETTING PARAMETER LIKE PREPARED STATEMENT OF JDBC , USE : INSTEAD OF ?
		 
//		int tmp = 50;
//		Query q = session.createQuery("select sum(marks) from Student s where s.rollno<=7 AND s.marks > :temp");
//		q.setParameter("temp", tmp);
//		Long totalMarks = (Long)q.uniqueResult(); //Shouldn't use Integer instead of Long
//		System.out.println(totalMarks);		

		
		
		
		session.getTransaction().commit();
		System.out.println("Transaction Completed");



	}
}