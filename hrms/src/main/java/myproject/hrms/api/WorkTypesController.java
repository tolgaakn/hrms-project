package myproject.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.business.abstracts.WorkTypeService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/workTypes")
@CrossOrigin
public class WorkTypesController {
	
	private WorkTypeService workTypeService;

	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkType>> getAll(){
		return workTypeService.getAll();
	}
	
}
