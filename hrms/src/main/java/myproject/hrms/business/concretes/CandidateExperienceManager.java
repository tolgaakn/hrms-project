package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.CandidateExperienceService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.CandidateExperienceDao;
import myproject.hrms.entities.concretes.CandidateExperience;

@Service
public class CandidateExperienceManager implements CandidateExperienceService {

	private CandidateExperienceDao candidateExperienceDao;
	
	@Autowired
	public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao) {
		super();
		this.candidateExperienceDao = candidateExperienceDao;
	}

	@Override
	public Result add(CandidateExperience candidateExperience) {
		this.candidateExperienceDao.save(candidateExperience);
		return new SuccessResult("İş deneyimi eklendi.");
	}

	@Override
	public DataResult<List<CandidateExperience>> getByCurriculumVitaesId(int curriculumVitaesId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "quitDate");
		return new SuccessDataResult<List<CandidateExperience>>(this.candidateExperienceDao.getByCurriculumVitaeId(sort, curriculumVitaesId));
	}

}
