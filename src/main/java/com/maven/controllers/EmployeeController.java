package com.maven.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maven.models.Employee;
import com.maven.services.EmployeeService;
import com.maven.services.IEmployeeService;

@Controller
public class EmployeeController {

	// @Resource(name = "employeeService")
	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String showList(ModelMap model) {
		List employee_list = employeeService.getAll();
		model.addAttribute("employees", employee_list);
		return "employees";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		System.out.println("Request to open the new user form page");
		model.addAttribute("employeeAttr", new Employee());
		return "add";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employeeAttr") @Valid Employee employee, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "add";
		}

		System.out.println("Incoming employee id:" + employee.getId());
		if (employee.getId() == 0.0d) {
			System.out.println("Edit");
		} else {
			System.out.println("Add....");
			employeeService.add(employee);
			System.out.println("Employee added");
		}
		return "redirect:employees";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewEmployee(ModelMap model, @RequestParam Double id) {
		System.out.println("View the employee individually");
		Employee employee = employeeService.get(id);
		model.addAttribute("employee", employee);

		return "view";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateEmployee(ModelMap model, @RequestParam Double id) {
		System.out.println("View the employee individually");
		Employee employee = employeeService.get(id);
		model.addAttribute("employee", employee);
		model.addAttribute("id", id);
		System.out.println("Id going from updateEmployee method in controller: " + employee.getId());
		System.out.println(employee); // correct
		return "update";
	}

	@RequestMapping(value = "/updated", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "update";
		}
		System.out.println("Id coming to /updated - " + employee.getId());
		if (employee.getId() == 0.0d) {
			System.out.println("Edit");
		} else {
			employeeService.update(employee);
			System.out.println("Update");
			System.out.println("Updated? ");
			System.out.println("Employee updated");
		}
		return "redirect:employees";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam Double id) {
		employeeService.delete(id);
		return "redirect:employees";
	}

}