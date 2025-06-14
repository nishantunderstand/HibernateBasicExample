package com.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	// Primary Key is really important
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	
	//@Column(name = "student_name", length = 100, unique = true)
	@Column(name = "student_name", length = 100)
	private String name;
	
	@Column(name = "student_college", length = 200, nullable = true)
	private String college;
	
	private String phone;
	
	private String fatherName;
	
	private boolean active = true;
	
	@Lob
	private String about;

	public Student() {	
	}

	public Student(String name, String college, String phone, String fatherName, boolean active, String about) {
	    this.name = name;
	    this.college = college;
	    this.phone = phone;
	    this.fatherName = fatherName;
	    this.active = active;
	    this.about = about;
	}


	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
