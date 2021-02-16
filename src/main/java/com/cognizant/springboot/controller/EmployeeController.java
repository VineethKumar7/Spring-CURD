package com.cognizant.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.springboot.model.Employee;
import com.cognizant.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * Creating method handler for homepage (index.html) 
	 * to display a list of employees
	 * 
	 * We need to supply list of employees to the view here for that we need to use the model as Parameter
	 */
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		//Create a model attribute to bind form data		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
//	Note here we need to handle the form data we pass @ModelAttribute("employee") so that all the form data will get binded to employee
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee ) {
		// save employee to the database	
		employeeService.saveEmployee(employee);
		//Note this how we redirect to the home page		
		return "redirect:/";
	}
}
