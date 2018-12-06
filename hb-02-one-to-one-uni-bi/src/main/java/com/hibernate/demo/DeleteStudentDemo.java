package com.hibernate.demo;

import com.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("Duplicates")
public class DeleteStudentDemo
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

			int studentId = Integer.valueOf("2");
			session.beginTransaction();
			Student myStudent = session.get(Student.class, studentId);
			session.delete(myStudent);
			session.createQuery("delete from Student where id=3").executeUpdate();
			session.getTransaction().commit();


			System.out.println("Done!");
		}
		finally {
			factory.close();
		}


	}
}
