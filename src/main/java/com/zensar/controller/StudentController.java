package com.zensar.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.StudentDto;
import com.zensar.service.StudentService;

@RestController
@RequestMapping(value = "/studentapi", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);
	}

	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDto>> getAllStudents(
			@RequestParam(required = false, defaultValue = "0") int pageNumber,
			@RequestParam(required = false, defaultValue = "5") int pageSize) {
		return new ResponseEntity<List<StudentDto>>(studentService.getAllStudents(pageNumber, pageSize), HttpStatus.OK);
	}

	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudents(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentService.insertStudents(studentDto), HttpStatus.CREATED);
	}

	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<String> updateStudents(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {
		studentService.updateStudents(studentId, studentDto);
		return new ResponseEntity<String>("Student updated sucessfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<String> deleteStudents(@PathVariable("studentId") int studentId) {
		studentService.deleteStudents(studentId);
		return new ResponseEntity<String>("Student deleted sucessfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/students/name/{studentName}")
	public ResponseEntity<List<StudentDto>> getByStudentName(@PathVariable("studentName") String studentName) {
		return new ResponseEntity<List<StudentDto>>(studentService.testName(studentName), HttpStatus.OK);
	}

	@GetMapping("/students/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> findByStudentNameAndStudentAge(@PathVariable String studentName,
			@PathVariable int studentAge) {
		return new ResponseEntity<List<StudentDto>>(studentService.testNameAndAge(studentName, studentAge),
				HttpStatus.OK);
	}

	@GetMapping("/students/age/{studentAge}")
	public ResponseEntity<List<StudentDto>> findByStudentAgeGreaterThan(@PathVariable int studentAge) {
		return new ResponseEntity<List<StudentDto>>(studentService.testAgeGreaterThan(studentAge), HttpStatus.OK);
	}

	@GetMapping("/students/sname/{studentName}")
	public ResponseEntity<List<StudentDto>> testStartsWithName(@PathVariable String studentName) {
		return new ResponseEntity<List<StudentDto>>(studentService.testStartsWithName(studentName), HttpStatus.OK);
	}

	@GetMapping("/students/asum")
	public int sumAge() {
		return studentService.sumAge();
	}
}
