package myproject.hrms.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getJobAdvertisementDetails")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails(Boolean isActive){
		return this.jobAdvertisementService.getJobAdvertisementDetails(isActive);
	}
	
	@GetMapping("/getAllSortedAscByIsActive")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsOrderByCreatedDateAsc(){
		return this.jobAdvertisementService.getAllSortedAscByIsActive();
	}
	
	@GetMapping("/getAllSortedDescByIsActive")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsOrderByCreatedDateDesc(){
		return this.jobAdvertisementService.getAllSortedDescByIsActive();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int jobAdvertisementId, @RequestParam int employerId) {
		return this.jobAdvertisementService.delete(jobAdvertisementId, employerId);
	}
	
	@PostMapping("/updateDeactiveJobAdvertisement")
	public Result updateDeactiveJobAdvertisement(@RequestParam int jobAdvertisementId, @RequestParam int employerId) {
		return this.jobAdvertisementService.updateDeactiveJobAdvertisement(jobAdvertisementId, employerId);
	}
}
