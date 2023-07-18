package com.tousif.crud_demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class CrudWithCriteria {
	
	private static SessionFactory sessionFactory;

	
	/*Method to CREATE an STUDENT in the DATABASE*/
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

	
	/*Method to READ all STUDENTS from the DATABASE*/
	public void listStudents() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Transaction Started");
		
		Criteria cr = session.createCriteria(Student.class);
		List<Student> student1 = cr.list();

		for(Student s : student1) {
			System.out.println(s);
		}
		
		session.getTransaction().commit();
		System.out.println("Transaction Completed");
		
	}
	
	
	/*Method to COUNT total STUDENTS from the DATABASE*/
	public void countStudents() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Transaction Started");
		
		Criteria cr = session.createCriteria(Student.class);
		
		cr.setProjection(Projections.rowCount());
		System.out.println(cr.list());
		
		session.getTransaction().commit();
		System.out.println("Transaction Completed");
	}
	
	
	/*Method to COUNT total MARKS from the DATABASE*/
	public void totalMarks() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Transaction Started");
		
		Criteria cr = session.createCriteria(Student.class);
		
		cr.setProjection(Projections.sum("marks"));
		System.out.println(cr.list());
		
		session.getTransaction().commit();
		System.out.println("Transaction Completed");
	}
	
	
	/*Method to GET Students from the DATABASE which MATHCES Specified PATTERN*/
	public void nameLike(String like) {
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Transaction Started");
		
		Criteria cr = session.createCriteria(Student.class);
		cr.add(Restrictions.like("name", like));
		
		List<Student> student = cr.list();
		
		for(Student s : student) {
			
			System.out.println(s);
			
		}
		
		session.getTransaction().commit();
		System.out.println("Transaction Completed");
		
	}
	
	/*Method to UPDATE MARKS*/
	public void updateMarks(int sid, int newMarks) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Transaction Started");
		
		String hql = "UPDATE Student set marks = :newMarks WHERE id = :sid ";
		
		Query query = session.createQuery(hql);
		query.setParameter("newMarks", newMarks);
		query.setParameter("sid", sid);
		query.executeUpdate();
		
		session.getTransaction().commit();
		System.out.println("Transaction Completed");
	}
	
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Student.class);

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();

		ServiceRegistry reg = srb.applySettings(config.getProperties()).buildServiceRegistry();

		sessionFactory = config.buildSessionFactory(reg);

//<--------------------------------------------------------------------------------------------------->

		
		CrudWithCriteria cwc = new CrudWithCriteria();
		
//		cwc.addStudent(11,"Name11",11);
//		cwc.addStudent(12,"Name12",12);
		
		cwc.listStudents();
		
		cwc.countStudents();
		
		cwc.totalMarks();
		
		cwc.nameLike("%2");
		
		cwc.updateMarks(12, 21);
		
		

		
		
		

	
	
	
	}
	
	
}
