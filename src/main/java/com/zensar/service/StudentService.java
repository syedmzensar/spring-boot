package com.zensar.service;

import java.util.List;

import com.zensar.dto.StudentDto;
import com.zensar.entity.Student;

public interface StudentService {

	public StudentDto getStudent(int studentId);

	public List<StudentDto> getAllStudents();

	public StudentDto insertStudents(StudentDto studentDto);

	public void updateStudents(int studentId, StudentDto studentDto);

	public void deleteStudents(int studentId);

}
