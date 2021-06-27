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

import myproject.hrms.business.abstracts.CandidateExperienceService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CandidateExperience;

@RestController
@RequestMapping("/api/candidateExperiences")
@CrossOrigin
public class CandidateExperiencesController {

	private CandidateExperienceService candidateExperienceService;

	@Autowired
	public CandidateExperiencesController(CandidateExperienceService candidateExperienceService) {
		super();
		this.candidateExperienceService = candidateExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateExperience candidateExperience) {
		return this.candidateExperienceService.add(candidateExperience);
	}
	
	@GetMapping("/getByCurriculumVitaeId")
	public DataResult<List<CandidateExperience>> getByCurriculumVitaesId(@RequestParam int curriculumVitaeId){
		return this.candidateExperienceService.getByCurriculumVitaesId(curriculumVitaeId);
	}
}
