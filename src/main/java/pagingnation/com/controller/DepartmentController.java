package pagingnation.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pagingnation.com.model.Department;
import pagingnation.com.model.DepartmentRequest;
import pagingnation.com.model.DepartmentResponce;
import pagingnation.com.service.DepartmentService;

@RestController
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
//	@GetMapping
//	public DepartmentResponce getAllDataOfDepartment(@RequestBody DepartmentRequest request) {
//		return departmentService.getAllDataFromDepartment(request);
//	}
	@GetMapping
	public DepartmentResponce getAllDataOfDepartment(
			@RequestParam(value = "page", defaultValue = "1", required = true) Integer page,
			@RequestParam(value = "pageSize", defaultValue = "5", required = true)Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "management", required = true)String manegement,
			@RequestParam(value = "sortDirection", defaultValue = "DESC", required = true)String sortDirection){
		return departmentService.getAllDataFromDepartment( page, pageSize, manegement, sortDirection);
	}
	
	@PostMapping(value = "/postdepartmentdata")
	public Department postAllData(@RequestBody DepartmentRequest request) {
		return departmentService.addDeparmentData(request);
	}

}
