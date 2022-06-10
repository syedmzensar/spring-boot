package com.zensar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Student;

@RestController
public class StudentController {

	private List<Student> students = new ArrayList<Student>();;

	/*
	 * public StudentController(){ students.add(new Student(1, "Syed", 20));
	 * students.add(new Student(2, "Rahul", 22)); students.add(new Student(3, "Bob",
	 * 16)); }
	 */

	@RequestMapping(value = "/student/{studentId}", method=RequestMethod.GET)
	public Student getStudent(@PathVariable("studentId") int studentId) {
		for (Student student : students) {
			if (student.getStudentId() == studentId) {
				return student;
			}
		}
		return null;
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		return students;
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student insertStudents(@RequestBody Student student) {
		students.add(student);
		
		return student;
	}
	
	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.PUT)
	public Student updateStudents(@PathVariable("studentId") int studentId, 
			@RequestBody Student student) {
		Student studentUpdate  = getStudent(studentId);
		studentUpdate.setStudentId(student.getStudentId());
		studentUpdate.setStudentName(student.getStudentName());
		studentUpdate.setStudentAge(student.getStudentAge());
		
		students.add(studentUpdate);
		
		return studentUpdate;
	}
	
	
	
	  @RequestMapping(value = "/students", method = RequestMethod.POST) public void
	  insertAllStudents(@RequestBody List<Student> student) {
	  students.addAll(student); }
	 

	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
	public void deleteStudents(@PathVariable("studentId") int studentId) {

		Iterator<Student> it = students.iterator();

		while (it.hasNext()) {
			Student student = it.next();
			if (student.getStudentId() == studentId) {
				it.remove();
			}
		}
	}
}
