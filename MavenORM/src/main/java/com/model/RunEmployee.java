package com.model;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javassist.expr.NewArray;

public class RunEmployee {

	public static void main(String[] args) {

		//oneToOne();
		oneToMany();
		
	}

	// one to one

	static void oneToOne() {
             
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Address address = new Address();
		address.setCountry("Nepal");
		address.setCity("Kathmandu");
		address.setState("state-3");
		
		session.save(address);
		
		Employee employee = new Employee();
		
		employee.setName("Raj Kumar");
		employee.setGender("male");
		employee.setAddress(address);
		
		session.save(employee);
		
		session.getTransaction().commit();
		
		session.close();
		
		
}
	
	public static void oneToMany() {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Address address = new Address();
		address.setCountry("Nepal");
		address.setCity("Kathmandu");
		address.setState("state-3");
		
		session.save(address);
		
		
		
		
		Employee employee = new Employee();
		
		employee.setName("Raj Kumar");
		employee.setGender("male");
		employee.setAddress(address);
		
		
		Phone phone1 = new Phone();
		phone1.setNumber("981667754");
		phone1.setType("NCELL");
        phone1.setEmployee(employee);
        session.save(phone1);
        
        Phone phone2 = new Phone();
		phone2.setNumber("984667754");
		phone2.setType("NTC");
        phone2.setEmployee(employee);
        session.save(phone2);
        
        employee.setPhones(Arrays.asList(phone1,phone2));
		
		session.save(employee);
		
		session.getTransaction().commit();
		
		session.close();
		
		
		
		
	}

}
