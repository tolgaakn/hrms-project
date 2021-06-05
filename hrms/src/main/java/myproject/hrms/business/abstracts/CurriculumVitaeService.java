package myproject.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {

	Result add(CurriculumVitae curriculumVitae);
	
	DataResult<List<CurriculumVitae>> getAll();
	
	DataResult<List<CurriculumVitae>> getByCandidateId(int candidateId);
	
	DataResult<CurriculumVitae> getById(int id);
	
	Result addImage(int id, MultipartFile multipartFile);
}
