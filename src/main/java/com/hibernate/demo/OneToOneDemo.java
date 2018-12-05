package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;;

public class OneToOneDemo
{
	public static void main(String[] args)
	{
		// create the session factory

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		//create a session
		Session session = factory.getCurrentSession();

		// wrap the persistence around  a try finally block `

		try { 				
				// asociate the two objects
				// tempInstructor.setInstructorDetail(tempInstructorDetail);
				session.beginTransaction();
				Instructor tempInstructor = session.get(Instructor.class, 1);
				session.delete(tempInstructor);
				// commit the change
				session.getTransaction().commit();

				System.out.println("Done!");
		}
		finally {
			factory.close();
		}


	}
}
