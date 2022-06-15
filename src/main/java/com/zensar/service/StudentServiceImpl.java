package com.zensar.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.StudentDto;
import com.zensar.entity.Student;
import com.zensar.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;

	public StudentDto getStudent(int studentId) {
		Student student = studentRepository.findById(studentId).get();

//		StudentDto studentToDto = mapToDto(student);

		return modelMapper.map(student, StudentDto.class);

//		return studentToDto;
	}

	public List<StudentDto> getAllStudents() {
		List<Student> listOfStudents = studentRepository.findAll();
		List<StudentDto> listOfStudentsDto = new ArrayList<StudentDto>();

		for (Student l : listOfStudents) {
//			listOfStudentsDto.add(mapToDto(l));
			listOfStudentsDto.add(modelMapper.map(l, StudentDto.class));
		}

		return listOfStudentsDto;
	}

	public StudentDto insertStudents(StudentDto studentDto) {
//		Student insertedStudent = mapToEntity(studentDto);

		Student student = modelMapper.map(studentDto, Student.class);
		Student studentDtoInsert = studentRepository.save(student);

//		return mapToDto(insertedStudent);

		return modelMapper.map(studentDtoInsert, StudentDto.class);
	}

	public void updateStudents(int studentId, StudentDto studentDto) {

		modelMapper.map(studentDto, Student.class);

	}

	public void deleteStudents(int studentId) {
		studentRepository.deleteById(studentId);

	}

	/*
	 * public Student mapToEntity(StudentDto studentDto) { Student student = new
	 * Student(); student.setStudentId(studentDto.getStudentId());
	 * student.setStudentName(studentDto.getStudentName());
	 * student.setStudentAge(studentDto.getStudentAge());
	 * 
	 * return student; }
	 * 
	 * public StudentDto mapToDto(Student student) { StudentDto studentDto = new
	 * StudentDto(); studentDto.setStudentId(student.getStudentId());
	 * studentDto.setStudentName(student.getStudentName());
	 * studentDto.setStudentAge(student.getStudentAge());
	 * 
	 * return studentDto; }
	 */

	/*
	 * @RequestMapping(value = "/students", method = RequestMethod.POST) public void
	 * insertAllStudents(@RequestBody List<Student> student) {
	 * students.addAll(student); }
	 */

}
