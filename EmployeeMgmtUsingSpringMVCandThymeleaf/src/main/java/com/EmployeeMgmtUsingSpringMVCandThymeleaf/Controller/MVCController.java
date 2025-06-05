package com.EmployeeMgmtUsingSpringMVCandThymeleaf.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeMgmtUsingSpringMVCandThymeleaf.Entity.Employee;
import com.EmployeeMgmtUsingSpringMVCandThymeleaf.ServiceLayer.EmployeeService;

@Controller
@RequestMapping("/employee")
public class MVCController {

	@Autowired
	private ConfigurableApplicationContext applicationContext;
	private int beats = 0;
	@Autowired
	private EmployeeService empServ;

	@GetMapping("/home")
	public String homePage() {
		beats=0;
		return "employee/home-page";
	}
	
	@GetMapping("/employee")
	public String forEmployees(Model model)
	{
		List<Employee> emplist = empServ.findAll();
		model.addAttribute("emplist", emplist);
		return "employee/for-employee";
	}
	
	@GetMapping("/manager")
	public String forManagers(Model model)
	{
		List<Employee> emplist = empServ.findAll();
		model.addAttribute("emplist", emplist);
		return "employee/for-manager";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		beats=0;
		return "employee/about";
	}

	@GetMapping("/list")
	public String listEmployee(Model model) {
		List<Employee> emplist = empServ.findAll();
		model.addAttribute("emplist", emplist);
		return "employee/employee-list";
	}

	@GetMapping("/showForm")
	public String showForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee/employee-form";
	}

	@PostMapping("/add")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		empServ.save(employee);
		return "redirect:/employee/list";
	}

	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("id") int id, Model model) {
		List<Employee> emp = empServ.findById(id);
		model.addAttribute("employee", emp.get(0));
		return "employee/employee-form";
	}

	@GetMapping("/delete")
	public String showFormDelete(@RequestParam("id") int id) {
		empServ.delete(id);
		return "redirect:/employee/list";
	}

	@GetMapping("/showFormSearch")
	public String showFormSearch(@RequestParam(name = "find", required = false) String key, Model model) {
		List<Employee> list = new ArrayList<>();
		if (key != null && !key.isEmpty()) {
			try {
				int id = Integer.parseInt(key);
				list.addAll(empServ.findById(id));
			} catch (NumberFormatException e) {
				list.addAll(empServ.findByFirstname(key));
				list.addAll(empServ.findByLastname(key));
			}
		} else {
			list = empServ.findAll();
		}
		model.addAttribute("employee", list);
		return "employee/employee-searchlist";
	}

	@Scheduled(fixedRate = 3000)
	public void schedule() {
	    beats++;
	    System.out.println("Beats :"+ beats);
	    //check how many heartbeats are missed and if it reaches to a certain value
	    if(beats >= 20) {
	        //terminate the JVM (also terminates the servlet context in Eclipse)
	        System.exit(0);
	    }
	}

}
