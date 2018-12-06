package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.demo.entity.Student;

public class CreateStudentDemo
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


			//create the student object
			System.out.println("Creating a student object ....");
//			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

			// Automate the creation of students a tad
			Student[] studentRef = new Student [1];
			String[] firstNames = {"Mduduzi", "Sisasenkosi", "Petty"};
			String[] lastNames = {"Dube", "Mkwananzi", "Mkwananzi"};
			String[] emails = {"mdufreds@cooltoad.com", "smkwananzi@gmail.com", "mkwananzi@gmail.com"};

			int i = 0;
			session.beginTransaction();
			for(Student std: studentRef)
			{
				std = new Student();
				std.setFirstName(firstNames[i]);
				std.setLastName(lastNames[i]);
				std.setEmail(emails[i]);
				// use the session object to save the Java object
				session.save(std);
				i++;
			}

			// commit the change
			session.getTransaction().commit();

			System.out.println("Done");
		}
		finally {
			factory.close();
		}


	}
}
