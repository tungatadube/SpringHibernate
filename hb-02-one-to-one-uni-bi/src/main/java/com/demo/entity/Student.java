package com.demo.entity;


import javax.persistence.*;

@Entity // designates this class as a special class that will communicate with the database
@Table(name="student")
public class Student
{
	@Id //  Says this column is the primary key column
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="first_name")
	private  String firstName;

	@Column(name="last_name")
	private  String lastName;

	@Column(name="email")
	private  String email;

	public Student()
	{

	}

	public Student(String firstName, String lastName, String email)
	{

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "Student{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
}
