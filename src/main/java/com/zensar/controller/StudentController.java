package com.zensar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.StudentDto;
import com.zensar.entity.Student;
import com.zensar.service.StudentService;

@RestController
@RequestMapping(value = "/studentapi", 
		produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
		consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/student/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);
	}

	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		return new ResponseEntity<List<StudentDto>>(studentService.getAllStudents(), HttpStatus.OK);
	}

	@PostMapping(value = "/student")
	public ResponseEntity<StudentDto> insertStudents(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentService.insertStudents(studentDto), HttpStatus.CREATED);
	}

	@PutMapping(value = "/student/{studentId}")
	public ResponseEntity<String> updateStudents(@PathVariable("studentId") int studentId, @RequestBody StudentDto studentDto) {
		studentService.updateStudents(studentId, studentDto);
		return new ResponseEntity<String>("Student updated sucessfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<String> deleteStudents(@PathVariable("studentId") int studentId) {
		studentService.deleteStudents(studentId);
		return new ResponseEntity<String>("Student deleted sucessfully", HttpStatus.ACCEPTED);
	}
}
