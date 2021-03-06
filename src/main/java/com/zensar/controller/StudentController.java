package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.StudentDto;
import com.zensar.exception.ProductException;
import com.zensar.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
/*
 * @RequestMapping(value = "/studentapi", produces = {
 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes
 * = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
 */
@Tag(name = "Student", description = "Student Database System")
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
			@RequestParam(required = false, defaultValue = "50") int pageSize,
			@RequestParam(required = false, defaultValue = "studentAge") String propertyName,
			@RequestParam(required = false, defaultValue = "ASC") Direction direction) {
		return new ResponseEntity<List<StudentDto>>(
				studentService.getAllStudents(pageNumber, pageSize, propertyName, direction), HttpStatus.OK);
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
