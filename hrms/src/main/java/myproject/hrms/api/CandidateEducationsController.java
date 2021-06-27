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

import myproject.hrms.business.abstracts.CandidateEducationService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CandidateEducation;

@RestController
@RequestMapping("/api/candidateEducations")
@CrossOrigin
public class CandidateEducationsController {

	private CandidateEducationService candidateEducationService;

	@Autowired
	public CandidateEducationsController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateEducation candidateEducation) {
		return this.candidateEducationService.add(candidateEducation);
	}
	
	@GetMapping("/getByCurriculumVitaeId")
	public DataResult<List<CandidateEducation>> getByCurriculumVitaesId(@RequestParam int curriculumVitaeId){
		return this.candidateEducationService.getByCurriculumVitaesId(curriculumVitaeId);
	}
}
