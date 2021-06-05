package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceService {
	Result add(CandidateExperience candidateExperience);
	
	DataResult<List<CandidateExperience>> getByCurriculumVitaesId(int curriculumVitaesId);
}
