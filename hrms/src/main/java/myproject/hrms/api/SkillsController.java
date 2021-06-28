package myproject.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.business.abstracts.SkillService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillsController {

	private SkillService skillService;

	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Skill>> getAll(){
		return skillService.getAll();
	}
}
