package myproject.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.business.abstracts.CandidateSkillService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CandidateSkill;

@RestController
@RequestMapping("/api/candidateSkills")
@CrossOrigin
public class CandidateSkillsController {

	private CandidateSkillService candidateSkillService;

	@Autowired
	public CandidateSkillsController(CandidateSkillService candidateSkillService) {
		super();
		this.candidateSkillService = candidateSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSkill candidateSkill) {
		return this.candidateSkillService.add(candidateSkill);
	}
	
	public DataResult<List<CandidateSkill>> getByCurriculumVitaeIs(@RequestParam int curriculumVitaeId){
		return this.candidateSkillService.getByCurriculumVitaeId(curriculumVitaeId);
	}
}
