package com.zensar.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private List<Student> students = new ArrayList<Student>();;

	public StudentServiceImpl() {
		students.add(new Student(1, "Syed", 20));
		students.add(new Student(2, "Rahul", 22));
		students.add(new Student(3, "Bob", 16));
	}

	public Student getStudent(int studentId) {
		for (Student student : students) {
			if (student.getStudentId() == studentId) {
				return student;
			}
		}
		return null;
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public void insertStudents(Student student) {
		students.add(student);
	}

	public void updateStudents(int studentId, Student student) {
		Student studentUpdate = getStudent(studentId);
		studentUpdate.setStudentId(student.getStudentId());
		studentUpdate.setStudentName(student.getStudentName());
		studentUpdate.setStudentAge(student.getStudentAge());

	}

	public void deleteStudents(int studentId) {
		Iterator<Student> it = students.iterator();

		while (it.hasNext()) {
			Student student = it.next();
			if (student.getStudentId() == studentId) {
				it.remove();
			}
		}

	}

	/*
	 * @RequestMapping(value = "/students", method = RequestMethod.POST) public void
	 * insertAllStudents(@RequestBody List<Student> student) {
	 * students.addAll(student); }
	 */

}
