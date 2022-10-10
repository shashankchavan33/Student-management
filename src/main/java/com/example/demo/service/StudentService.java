package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudent();

	Student getStudentById(Long id);
	
	Student updateStudentById(Student student, Long id);
	
	void deleteStudentById(Long id);

} 
