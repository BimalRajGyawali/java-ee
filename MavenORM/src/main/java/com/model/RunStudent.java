package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunStudent {

	public static void main(String[] args) {

		//addStudent();
		
		delete();
		
		//getAll();
		
		//update();
		
		getAll();

	}

	static void addStudent() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Student student = new Student();
		student.setFname("Ram");
		student.setLname("Kumar");
		student.setAddress("KTM");
		student.setPhone("987556732");
		student.setRollno(23);

		session.save(student); // insert sql

		Student student1 = new Student();
		student.setFname("Ramesh");
		student.setLname("Raj");
		student.setAddress("KTM");
		student.setPhone("987556732");
		student.setRollno(23);

		session.save(student);

		session.getTransaction().commit(); // execute sql or fire

		session.close();

	}

	static void getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		
		Criteria criteria = session.createCriteria(Student.class); //persistence class
		
		List<Student> students = criteria.list();
		
		for(Student student : students)
		{
			System.out.println(student);
		}
		
		
		

	}
	
	static void update()
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		Student student = (Student)session.get(Student.class, 1); // 1 is id
		
		student.setAddress("Lainchaur");
		
		
		session.update(student);

		session.getTransaction().commit();
		
		session.close();
		
		
		
	}
	
	
	static void delete()
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Student student = (Student) session.get(Student.class, 1);
		
		session.delete(student);
		
		session.beginTransaction().commit();
		
		session.close();
		
		
		
		
	}

}
