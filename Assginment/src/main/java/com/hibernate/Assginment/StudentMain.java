package com.hibernate.Assginment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class StudentMain {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		//Illustrating insertion
		Student s=new Student();
		s.setRoll_no(201);
		s.setName("Rocky");
		s.setMarks(91.90);
		session.save(s);
		session.getTransaction().commit();
		
		//Illustrating Select
		Student s1=session.get(Student.class, 1);
		System.out.println(s1.getName());
		
		//Illustrating delete
		session.beginTransaction();
		Student s2=session.get(Student.class, 1);
		session.delete(s2);
		session.getTransaction().commit();
		session.clear();
				
		//Illustrating Update
		
		session.beginTransaction();
		Student s3=session.get(Student.class, 1);
		if(s3!=null) {
					s3.setName(null);
					s3.setMarks(99.80);
					session.saveOrUpdate(s3);
					session.getTransaction().commit();
				}
				System.out.println("Id not found");
				session.close();
				
			}

				
	}

