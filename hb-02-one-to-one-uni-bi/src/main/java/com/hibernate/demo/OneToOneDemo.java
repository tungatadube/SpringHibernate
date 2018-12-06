package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.JOptionPane;

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

		// wrap the persistence around  a try finally block 

		try { 				
				session.beginTransaction();
				Instructor tempInstructor = new Instructor("Ndumiso", "Dube","ndube@tmn.co.zw" );
				InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/Ndumiso", "Loves to read" );
				//Link these two objects together
				tempInstructor.setInstructorDetail(tempInstructorDetail);
				session.save(tempInstructor);
				// commit the change
				session.getTransaction().commit();
				System.out.println("Done!");
		}
		finally{
			session.close();
		}
		// Deleting the insructor
		int id = 13;

		try{
			session = factory.getCurrentSession();
			session.beginTransaction();
			Instructor instructorToDelete = session.get(Instructor.class, 13);
			JOptionPane.showConfirmDialog(null, String.format("Deleting: %s\n ", instructorToDelete.toString()));
			session.delete(instructorToDelete);
			session.getTransaction().commit();

		}
		catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, String.format("This object of id %d was not found on the database", id), "No Object Found", 1);
		}
		finally {
			factory.close();
		}


	}
}
