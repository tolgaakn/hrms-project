package myproject.hrms.business.abstracts;


import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationService {

	Result add(CandidateEducation candidateEducation);
	
	DataResult<List<CandidateEducation>> getByCurriculumVitaesId(int curriculumVitaesId);
}
