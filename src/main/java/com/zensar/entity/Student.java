package com.zensar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//@NamedNativeQuery(name = "testName", query = "select * from student", resultClass = Student.class)
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue
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
