package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
