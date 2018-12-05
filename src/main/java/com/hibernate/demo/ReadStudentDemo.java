package com.hibernate.demo;

import com.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo
{
	public static void main(String[] args)
	{
		// create the session factory

		SessionFactory factory = null;
		try
		{
			factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}

		//create a session
		Session session = factory.getCurrentSession();

		// wrap the persistence around  a try finally block

		try {

			//create the student object
		    // Automate the creation of students a tad
			Student[] studentRef = new Student [1];
			String[] firstNames = {"Mpumelelo",};
			String[] lastNames = {"Dube", };
			String[] emails = {"mdube@gmail.com",};
			Student [] fullBlownstudents = new Student [1];

			int i = 0;
			session.beginTransaction();
			for(Student std: studentRef)
			{
				std = new Student();
				std.setFirstName(firstNames[i]);
				std.setLastName(lastNames[i]);
				std.setEmail(emails[i]);
				fullBlownstudents[i] = std;
				// use the session object to save the Java object
				session.save(std);
				i++;
			}

			// commit the change
			System.out.println("Saving the " + fullBlownstudents[0]);
			session.getTransaction().commit();

			// find out the id for the student and their primary key
			System.out.println("Saved student. Generated id:  " + fullBlownstudents[0].getId());

			// QUERYING

			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + fullBlownstudents[0].getId());
			Student retrievedStudent = session.get(Student.class, fullBlownstudents[0].getId());
			System.out.println("Get complete: " + retrievedStudent);
			// commit transaction
			session.getTransaction().commit();


			System.out.println("Done");

		}
		finally {
			factory.close();
		}


	}
}
