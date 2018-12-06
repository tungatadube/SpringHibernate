package com.hibernatetutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc
{

	public static void main(String[] args)
	{
		/*The mysql server should be running for this code to work
		* The server can be started with the command 'sudo /etc/init.d/mysql start'
		* There should exist a database schema of the name hb_student_tracker
		* @user hbstudent
		* @password hbstudent
		*
		* */
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";

		try
		{
			System.out.println("connecting to database:" + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful !!!");
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}

}
