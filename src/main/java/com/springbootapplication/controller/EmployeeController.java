package com.springbootapplication.controller;

import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.PutExchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootapplication.model.Employee;
import com.springbootapplication.repo.EmployeeRepo;
import com.springbootapplication.service.EmployeeService;
import com.springbootapplication.utility.RecordNotFoundException;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService objEmployeeService;
	
	@Autowired
	EmployeeRepo empRepo;
	

	@PutMapping("/updateEmployeeDetail")
	public String saveEmployeeDetail1(@RequestBody Employee emp)   {
		
                

      
       
        empRepo.save(emp);
		return "updated";
			
	}
	
	
	@GetMapping("/getEmployeeDetails")
	public List<Employee>  getEmployeeDetails() {
			
	return	objEmployeeService.getEmployeeDetail();
		
	}
	
	
	@PatchMapping("/saveEmployeeDetail")
	public Employee saveEmployeeDetail(@RequestBody Employee emp)   {
		 return empRepo.save(emp);
			
	}
	
	
	@GetMapping("/getEmployeeDetatailsById/{name}")
	public Employee  getEmployeeDetailsById(@PathVariable String name)  {
	return	objEmployeeService.getEmployeeDetailById(name);
		
	}
	
	@GetMapping("/getCleintData")
	public ResponseEntity<String>  getClientData() {
				RestTemplate objRestTemplate= new RestTemplate();
		HttpEntity<String> entity= new HttpEntity<String>("");
		ResponseEntity<String> response=objRestTemplate.exchange("http://localhost:8080/getClientInformation", HttpMethod.POST,entity, String.class);
		return response;
		
//	return	objEmployeeService.getEmployeeDetail();
		
	}
	
	
	@GetMapping("/saveCleintData")
	public HashMap  savingClientData(@RequestParam int id) throws JSONException, JsonProcessingException  {
		// empRepo.save(objEmp);
		 
				RestTemplate objRestTemplate= new RestTemplate();
//				JSONObject obj=new JSONObject();
//				obj.put("id", objEmp.getId() );
//				obj.put("age", objEmp.getAge() );
//				obj.put("name", objEmp.getName() );
				
				
				HttpHeaders objH= new HttpHeaders();
				objH.setContentType(MediaType.APPLICATION_JSON); 
				
				String Url="http://localhost:8080/clentRegistration?id="+id;
				
//				HashMap h= new HashMap();
//				h.put("id", objEmp.getId());
//				h.put("age", objEmp.getAge());
//				h.put("name", objEmp.getName());								
//					String 	jsonObj = new ObjectMapper().writeValueAsString(h);
					//HttpEntity<String> entity= new HttpEntity<String>( obj.toString(),objH);
					ResponseEntity<Employee> response=objRestTemplate.getForEntity(Url, Employee.class);
									
				HashMap h= new HashMap();
				if(response.getBody().getAge()!=0) {										
					h.put("Susheel",response.getBody().getAge());
				}
					return h;
				
				
				
		
		
	}
	
	
	
}
