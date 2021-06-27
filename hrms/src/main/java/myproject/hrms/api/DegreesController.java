package myproject.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.business.abstracts.DegreeService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.entities.concretes.Degree;

@RestController
@RequestMapping("/api/degrees")
@CrossOrigin
public class DegreesController {
	
	private DegreeService degreeService;

	public DegreesController(DegreeService degreeService) {
		super();
		this.degreeService = degreeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Degree>> getAll(){
		return degreeService.getAll();
	}
}
