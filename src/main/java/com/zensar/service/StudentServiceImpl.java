package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

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

	public List<StudentDto> getAllStudents(int pageNumber, int pageSize) {
//		List<Student> listOfStudents = studentRepository.findAll();
		List<StudentDto> listOfStudentsDto = new ArrayList<StudentDto>();

		Page<Student> findAllStudents = studentRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("studentId").descending()));

		List<Student> students = findAllStudents.getContent();

		for (Student student : students) {
			listOfStudentsDto.add(modelMapper.map(student, StudentDto.class));
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

	public List<StudentDto> testName(String studentName) {
		List<Student> listOfStudents = studentRepository.testName(studentName);
		List<StudentDto> listOfStudentsDto = new ArrayList<StudentDto>();

		for (Student student : listOfStudents) {
			listOfStudentsDto.add(modelMapper.map(student, StudentDto.class));
		}

		return listOfStudentsDto;

	}

	public List<StudentDto> testNameAndAge(String studentName, int studentAge) {
		List<Student> listOfStudents = studentRepository.testNameAndAge(studentName, studentAge);
		List<StudentDto> listOfStudentsDto = new ArrayList<StudentDto>();

		for (Student student : listOfStudents) {
			listOfStudentsDto.add(modelMapper.map(student, StudentDto.class));
		}

		return listOfStudentsDto;
	}

	public List<StudentDto> testAgeGreaterThan(int studentAge) {
		List<Student> listOfStudents = studentRepository.testAgeGreaterThan(studentAge);
		List<StudentDto> listOfStudentsDto = new ArrayList<StudentDto>();

		for (Student student : listOfStudents) {
			listOfStudentsDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentsDto;
	}

	public List<StudentDto> testStartsWithName(String studentName) {
		List<Student> listOfStudents = studentRepository.testStartsWithName(studentName);
		List<StudentDto> listOfStudentsDto = new ArrayList<StudentDto>();

		for (Student student : listOfStudents) {
			listOfStudentsDto.add(modelMapper.map(student, StudentDto.class));
		}

		return listOfStudentsDto;
	}

	public int sumAge() {
		return studentRepository.sumAge();
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
