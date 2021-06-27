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

import myproject.hrms.business.abstracts.CandidateLanguageService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CandidateLanguage;

@RestController
@RequestMapping("/api/candidateLanguages")
@CrossOrigin
public class CandidateLanguagesController {

	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLanguage candidateLanguage) {
		return this.candidateLanguageService.add(candidateLanguage);
	}
	
	@GetMapping("/getByCurriculumVitaesId")
	public DataResult<List<CandidateLanguage>> getByCurriculumVitaesId(@RequestParam int curriculumVitaeId){
		return this.candidateLanguageService.getByCurriculumVitaesId(curriculumVitaeId);
	}
}
