package com.springbootapplication.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springbootapplication.model.Employee;

@EnableJpaRepositories
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByName(String name);

	


}
