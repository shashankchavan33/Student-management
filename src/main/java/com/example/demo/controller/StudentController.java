package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// Build Create Student REST API
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	// Build get All Student
	@GetMapping
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	// get student by Id
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId) {
		return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);

	}

    //retrieve data
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable("id") Long id, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudentById(student, id), HttpStatus.OK);
	}

	// Delete API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);

		return new ResponseEntity<String>("Student Deleted sucessfully !", HttpStatus.OK);

	}
}
