/**
 * 
 */
package com.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @author Mehul
**/

@Document("employee_master")
@Data
public class Employee {

	@Id
	private int empId;
	private String empName;
	private String emailId;
	private int salary;
}
