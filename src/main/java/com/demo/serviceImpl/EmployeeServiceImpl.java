/**
 * 
 */
package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

/**
 * @author Mehul
**/

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void save(Employee employee) {
		mongoTemplate.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return mongoTemplate.findAll(Employee.class);
	}

	@Override
	public void deleteById(int empId) {
		mongoTemplate.remove(new Query(Criteria.where("empId").is(empId)), Employee.class);
	}

}
