package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {

	Result add(CandidateLanguage candidateLanguage);
	
	DataResult<List<CandidateLanguage>> getByCurriculumVitaeId(int curriculumVitaeId);
}
