package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.CandidateSkill;

public interface CandidateSkillService {

	Result add(CandidateSkill candidateSkill);
	
	DataResult<List<CandidateSkill>> getByCurriculumVitaeId(int curriculumVitaeId);
}
