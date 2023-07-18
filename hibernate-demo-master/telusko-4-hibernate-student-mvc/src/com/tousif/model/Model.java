package com.tousif.model;

import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.tousif.controller.GetResult;

public class Model {
	
	private static SessionFactory sf = null;
	
	int usn = 0;
	String name = null;
	int marks = 0;
	
	
	public void setUsn(int usn) {
		this.usn = usn;
		System.out.println("Received usn in model and usn is : "+usn);
	}
	
	
	
	public void getResult() {
		
	
		System.out.println("About to Open Session");
		
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Student.class);

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();

		ServiceRegistry reg = srb.applySettings(config.getProperties()).buildServiceRegistry();


		sf = config.buildSessionFactory(reg);
		
		
		
		Session session = sf.openSession();
		System.out.println("Session Opned");
		
		
		String hql1 = "select name, marks from Student where rollno = :usn";
		Query q1 = session.createQuery(hql1);
		q1.setParameter("usn", usn);
		
		Object[] student = (Object[])q1.uniqueResult();
		
		
		System.out.println("In Model USN :" + usn);
		
		name = student[0].toString();
		System.out.println("In Model NAME :" + name);
		
		marks = (Integer)student[1];
		System.out.println("In Model MARKS :" + marks);
		
		
	}
	
	public int getUsn() {
		return usn;
	}

	public String getName() {
		return name;
	}

	public int getMarks() {
		return marks;
	}

	

	public static void main(String[] args) {

		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Student.class);

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();

		ServiceRegistry reg = srb.applySettings(config.getProperties()).buildServiceRegistry();


		sf = config.buildSessionFactory(reg);
		

	}
}
