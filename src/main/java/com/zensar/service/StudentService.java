package com.zensar.service;

import java.util.List;

import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.springframework.data.domain.Sort.Direction;

import com.zensar.dto.StudentDto;

public interface StudentService {

	public StudentDto getStudent(int studentId);

	public List<StudentDto> getAllStudents(int pageNumber, int pageSize, String propertyName, Direction direction);

	public StudentDto insertStudents(StudentDto studentDto);

	public void updateStudents(int studentId, StudentDto studentDto);

	public void deleteStudents(int studentId);

	List<StudentDto> testName(String studentName);

	List<StudentDto> testNameAndAge(String studentName, int studentAge);

	List<StudentDto> testAgeGreaterThan(int studentAge);

	List<StudentDto> testStartsWithName(String studentName);

	int sumAge();
}
