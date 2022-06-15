package com.zensar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@Column(name = "id")
	private int studentId;

	@Column(name = "name")
	private String studentName;

	@Column(name = "age")
	private int studentAge;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, int studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	@Override
	public String toString() {
		return "StudentController [studentId=" + studentId + ", studentName=" + studentName + ", studentAge="
				+ studentAge + "]";
	}

}
