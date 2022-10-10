package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.Data;
//
@Data
@Entity
//@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="First_name", nullable=false)
	private String firstname;
	@Column(name="Last_name")
	private String lastname;
	@Column(name="Email")
	private String email;
}
