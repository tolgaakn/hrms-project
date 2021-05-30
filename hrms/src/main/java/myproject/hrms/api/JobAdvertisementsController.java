package myproject.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.business.abstracts.JobAdvertisementService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.JobAdvertisement;
import myproject.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisementDto>> findByIsActive(){
		return this.jobAdvertisementService.findByIsActive();
	}
	
	@GetMapping("/getallApplicationDeadline")
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndApplicationDeadline(){
		return this.jobAdvertisementService.findByIsActiveAndApplicationDeadline();
	}
	
	@GetMapping("/getallCompanyName")
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.findByIsActiveAndCompanyName(companyName);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobAdvertisementService.delete(id);
	}
}
