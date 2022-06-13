package com.zensar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Student;
import com.zensar.service.StudentService;

@RestController
@RequestMapping("/studentapi")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/student/{studentId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Student getStudent(@PathVariable("studentId") int studentId) {
		return studentService.getStudent(studentId);
	}

	@GetMapping(value = "/students", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping(value = "/student", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void insertStudents(@RequestBody Student student) {
		studentService.insertStudents(student);
	}

	@PutMapping(value = "/student/{studentId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void updateStudents(@PathVariable("studentId") int studentId, @RequestBody Student student) {
		studentService.updateStudents(studentId, student);
	}

	@DeleteMapping("/student/{studentId}")
	public void deleteStudents(@PathVariable("studentId") int studentId) {
		studentService.deleteStudents(studentId);
	}
}
