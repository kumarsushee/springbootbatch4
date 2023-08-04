package com.springbootapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="emptable")
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;	
	int age;
	String email;
	String address;
	
	
	

}
