package myproject.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import myproject.hrms.business.abstracts.CurriculumVitaeService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumVitaes")
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		return this.curriculumVitaeService.add(curriculumVitae);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumVitaeService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<CurriculumVitae>> getByCandidateId(@RequestParam int candidateId){
		return this.curriculumVitaeService.getByCandidateId(candidateId);
	}
	
	@GetMapping("/getById")
	public DataResult<CurriculumVitae> getById(@RequestParam int id){
		return this.curriculumVitaeService.getById(id);
	}
	
	@PostMapping("/addImage")
	public Result add(@RequestParam int curriculumVitaeId, @RequestParam MultipartFile file) {
		return this.curriculumVitaeService.addImage(curriculumVitaeId, file);
	}
}
