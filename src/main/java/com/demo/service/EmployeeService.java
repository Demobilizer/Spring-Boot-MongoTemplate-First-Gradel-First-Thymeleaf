/**
 * 
 */
package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

/**
 * @author Mehul
**/

public interface EmployeeService {

	/**
	 * @param employee
	 */
	void save(Employee employee);

	/**
	 * @return
	 */
	List<Employee> findAll();

	/**
	 * @param empId
	 */
	void deleteById(int empId);

}
