package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("from Student s where s.studentName=:name")
	List<Student> testName(@Param("name") String studentName);

	@Query("from Student s where s.studentName=:name and s.studentAge=:age")
	List<Student> testNameAndAge(@Param("name") String studentName, @Param("age") int studentAge);

	@Query(value = "select * from student where age>?1", nativeQuery = true)
	List<Student> testAgeGreaterThan(int studentAge);

	@Query(value = "select * from student where name like ?1%", nativeQuery = true)
	List<Student> testStartsWithName(String studentName);

	@Query(value = "select sum(age) from student", nativeQuery = true)
	int sumAge();

//	List<Student> findByStudentNameLike
}
