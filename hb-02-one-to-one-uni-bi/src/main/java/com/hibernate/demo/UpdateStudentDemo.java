package com.hibernate.demo;

import com.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo
{
	public static void main(String[] args)
	{
		// create the session factory

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		//create a session
		Session session = factory.getCurrentSession();

		// wrap the persistence around  a try finally block `

		try {

			int studentId = Integer.valueOf("3");
			session.beginTransaction();

			Student myStudent = session.get(Student.class, studentId);

			// change the value of student and persist it
			myStudent.setFirstName("Nonoza");
			myStudent.setEmail("nonoDube@twzholdings.co.zw");


			// commit the change
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='foo@gmail.com'")
					.executeUpdate();
			// Do-not forget to commit the session
			session.getTransaction().commit();


			System.out.println("Done");
		}
		finally {
			factory.close();
		}


	}
}
