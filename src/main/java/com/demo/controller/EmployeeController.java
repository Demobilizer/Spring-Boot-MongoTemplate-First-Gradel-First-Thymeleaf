/**
 * 
 */
package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

/**
 * @author Mehul
**/

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/add-employee")
	public ModelAndView getNext(Model m) {
		m.addAttribute("employee", new Employee());
		return new ModelAndView("add-employee");
	}
	
	@GetMapping("/edit-employee/{empId}")
	public ModelAndView editEmp(@PathVariable int empId, ModelAndView mv) {
		mv.addObject("editingEmp", employeeService.findEmployeeById(empId));
		mv.addObject("employees", employeeService.findAll());
		mv.setViewName("edit-employee");
		return mv;
	}
	
	@PostMapping("/save-employee")
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		logger.debug("employee to controller ---- "+employee);
		employeeService.save(employee);
		return new ModelAndView("redirect:/get-employees");
	}

	@GetMapping("/get-employees")
	public ModelAndView getAllEmployees(ModelAndView mv) {
		mv.addObject("employees", employeeService.findAll());
		mv.setViewName("view-employees");
		return mv;
	}
	
	@GetMapping("/update-cancel")
	public ModelAndView cancelUpdate() {
		return new ModelAndView("redirect:/get-employees");
	}

	@GetMapping("/delete/{empId}")
	public ModelAndView deleteEmployee(@PathVariable int empId) {
		employeeService.deleteById(empId);
		return new ModelAndView("redirect:/get-employees");
	}

	@PostMapping("/update/{empId}")
	public ModelAndView updateEmployee( @PathVariable int empId, @ModelAttribute Employee employee) {
		employee.setEmpId(empId);
		employeeService.save(employee);
		return new ModelAndView("redirect:/get-employees");
	}
	 
}
