/**
 * 
 */
package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

/**
 * @author Mehul
**/

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add-employee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "employee added successfully with: "+employee;
	}
	
	@GetMapping("/get-employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}
	
	@DeleteMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		employeeService.deleteById(empId);
		return "deleted employee with Id: "+empId;
	}
	
	@PutMapping("/update/{empId}")
	public String updateEmployee(@PathVariable int empId, @RequestBody Employee employee) {
		employee.setEmpId(empId);
		employeeService.save(employee);
		return "updated employee with Id: "+empId;
	}
}
