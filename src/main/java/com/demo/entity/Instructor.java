package com.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="instructor")
public class Instructor {


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;

	public Instructor(){

	}

	public Instructor(String lastName, String firstName, String email) {
		this.lastName= lastName;
		this.firstName = firstName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	@Override
	public String toString(){
		return String.format("Instructor [id=%d, firstName=%s, lastName=%s, instructorDetail=%s]"
							  ,id
							  ,firstName 
							  ,lastName
							  ,instructorDetail
							);
	}
}
