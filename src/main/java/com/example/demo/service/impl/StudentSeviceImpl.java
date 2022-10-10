package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import org.springframework.stereotype.Service;

@Service
public class StudentSeviceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentSeviceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	// save Student

	@Override
	public Student saveStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {

		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
//		Optional<Student> student = studentRepository.findById(id);
//		
//		/*
//		 * if(student.isPresent()) { return student.get();
//		 * 
//		 * } else { throw new ResourceNotFoundException("Student","Id",id); }
//		 */

		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stduent", "Id", id));
	}

	@Override
	public Student updateStudentById(Student student, Long id) {

		// we need to check whether data present in database
		Student existingstudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));

		existingstudent.setEmail(student.getFirstname());
		existingstudent.setLastname(student.getLastname());
		existingstudent.setEmail(student.getEmail());

		return studentRepository.save(existingstudent);
	}

	@Override
	public void deleteStudentById(Long id) {

		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
		studentRepository.deleteById(id);
	}

}
