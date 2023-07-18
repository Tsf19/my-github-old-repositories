package com.tousif.crud_demo;

import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class CrudWithHQL {
	
private static SessionFactory sessionFactory;



	public void appendTableS1S2() {


		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Transaction Started");

		String hql = "INSERT INTO Student(name, rollno, marks)"  + 
				"SELECT name, rollno, marks FROM Student2";

		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);


		session.getTransaction().commit();
		System.out.println("Transaction Completed");

}


	public void addStudent(int rollno, String name, int marks) {

		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Transaction Started");
		
		Student student = new Student();
		
		student.setRollno(rollno);
		student.setName(name);
		student.setMarks(marks);
		
		session.save(student);
		
		session.getTransaction().commit();
		System.out.println("Transaction Completed");
		
	}
	
	public void deleteStudent(int rollno) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Transaction Started");
				
		String hql = "DELETE from Student WHERE rollno = :rollno";
		Query query = session.createQuery(hql);
		query.setParameter("rollno", rollno);
		
		query.executeUpdate();
		
		session.getTransaction().commit();
		System.out.println("Transaction Completed");
		
	}
	
	
	public void updateMarks(int rollno, int newMarks) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Transaction Started");
		
		String hql = "UPDATE Student set marks = :newMarks WHERE rollno = :rollno ";
		
		Query query = session.createQuery(hql);
		query.setParameter("newMarks", newMarks);
		query.setParameter("rollno", rollno);
		query.executeUpdate();
		
		session.getTransaction().commit();
		System.out.println("Transaction Completed");
	}
	
	public static void main(String[] args) {
		

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Student.class).addAnnotatedClass(Student2.class);

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();

		ServiceRegistry reg = srb.applySettings(config.getProperties()).buildServiceRegistry();

		sessionFactory = config.buildSessionFactory(reg);

		
//<--------------------------------------------------------------------------------------------------->

		
		CrudWithHQL cwh = new CrudWithHQL();
		
//		cwh.appendTableS1S2();
		
//		cwh.addStudent(13,"Name13",13);
		
//		cwh.deleteStudent(13);
		
//		cwh.updateMarks(12, 24);
		
		
		
		

		
		
		

	
	
	
	}
}
