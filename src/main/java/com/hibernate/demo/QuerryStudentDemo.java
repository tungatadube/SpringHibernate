package com.hibernate.demo;

import com.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QuerryStudentDemo
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

		//create student


		//create a session
		Session session = factory.getCurrentSession();

		try{

			// start a transaction
			session.beginTransaction();
			//query the students
			List<Student> theStudents = session.createQuery("from com.demo.entity.Student s where s.lastName='Dube' or s.firstName='Ndumiso'").list();
			/*
			use fully qualified classname on the from despite having imported it at the import section of the source code.
			display the students
			commit the transaction
			*/

			// Read out the students onto the console

			displayStudents(theStudents);

			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}


	}

	private static void displayStudents(List<Student> theStudents)
	{
		for(Student student:theStudents)
		{
			System.out.println(student);
		}
	}
}
