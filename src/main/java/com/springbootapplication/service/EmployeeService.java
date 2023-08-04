package com.springbootapplication.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springbootapplication.model.Employee;
import com.springbootapplication.repo.EmployeeRepo;
import com.springbootapplication.utility.RecordNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo objEmployeeRepo;
	
	 @Autowired
	    private Environment env;
	
	@Value("${allow}")
	private Map<String,String> fruits;

	public String saveDetails(Employee emp, int id) {
		Optional<Employee> e = objEmployeeRepo.findById(id);
  
		if (e != null) {
			e.get().setAge(emp.getAge());
			e.get().setName(emp.getName());
			
			
			objEmployeeRepo.save(e.get());
						
		} else {
			objEmployeeRepo.save(e.get());
	
		}
		return null;

	}

	public List<Employee> getEmployeeDetail() {
		System.out.println(fruits);
		
		return objEmployeeRepo.findAll();

	}

	public Employee getEmployeeDetailById(String name) {		
		  Employee empRecord =  objEmployeeRepo.findByName(name);
		   if(empRecord==null) {
			   throw new RecordNotFoundException();
		   }
		   return empRecord;

	}

}
