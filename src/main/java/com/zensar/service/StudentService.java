package com.zensar.service;

import java.util.List;

import com.zensar.entity.Student;

public interface StudentService {

	public Student getStudent(int studentId);

	public List<Student> getAllStudents();

	public void insertStudents(Student student);

	public void updateStudents(int studentId, Student student);

	public void deleteStudents(int studentId);

}
