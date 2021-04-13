package com.nagarro.controller;

import com.nagarro.constant.Constant;
import com.nagarro.dto.Employee;
import com.nagarro.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getEmployeeList() {
		ModelAndView modelView = new ModelAndView();
		List<Employee> employees = employeeService.getAllEmployees();
		modelView.addObject("employees", employees);
		modelView.setViewName("homepage");
		return modelView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam(value = "id") long id,
			@RequestParam(value = "employeeCode") long employeeCode,
			@RequestParam(value = "employeeName") String employeeName,
			@RequestParam(value = "location") String location, @RequestParam(value = "email") String email,
			@RequestParam(value = "dateOfBirth") String dateOfBirth) {
		ModelAndView modelView = new ModelAndView();
		Employee employee = new Employee(id, employeeCode, employeeName, location, email, dateOfBirth);
		modelView.addObject("employee", employee);
		modelView.setViewName("/editEmployee");
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
		employeeService.addAllEmployees(file);
		return "redirect:/employee";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@RequestParam(value = "id") long id,
			@RequestParam(value = "employeeCode") long employeeCode,
			@RequestParam(value = "employeeName") String employeeName,
			@RequestParam(value = "location") String location, @RequestParam(value = "email") String email,
			@RequestParam(value = "dateOfBirth") String dateOfBirth) {
		ModelAndView modelView = new ModelAndView();
		Employee employee = new Employee(id, employeeCode, employeeName, location, email, dateOfBirth);
		employeeService.updateEmployee(employee);
		modelView.setViewName("redirect:/employee");
		return modelView;
	}

	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public void downloadFile(HttpServletResponse response) {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=" + Constant.CSV_FILE_NAME);
		try (ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE)) {
			employeeService.addEmployeeDetailsToFile(csvBeanWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
