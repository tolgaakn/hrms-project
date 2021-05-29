package myproject.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.business.abstracts.ConfirmByEmployeeService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.ConfirmByEmployee;

@RestController
@RequestMapping("/api/confirmbyemployees")
public class ConfirmByEmployeesController {

	private ConfirmByEmployeeService confirmByEmployeeService;

	@Autowired
	public ConfirmByEmployeesController(ConfirmByEmployeeService confirmByEmployeeService) {
		super();
		this.confirmByEmployeeService = confirmByEmployeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ConfirmByEmployee>> getAll(){
		return confirmByEmployeeService.getAll();
	}
	
	@GetMapping("/activate/{employerId}")
	public Result activateEmployer(@PathVariable int employerId) {
		return confirmByEmployeeService.activateEmployer(employerId);
	}
}
