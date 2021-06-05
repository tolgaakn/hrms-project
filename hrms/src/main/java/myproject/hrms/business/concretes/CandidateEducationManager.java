package myproject.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.CandidateEducationService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.CandidateEducationDao;
import myproject.hrms.entities.concretes.CandidateEducation;

@Service
public class CandidateEducationManager implements CandidateEducationService {

	private CandidateEducationDao candidateEducationDao;
	
	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		super();
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public Result add(CandidateEducation candidateEducation) {
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult("Eğitim bilgisi eklendi.");
	}

	@Override
	public DataResult<List<CandidateEducation>> getByCurriculumVitaesId(int curriculumVitaesId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "graduatedDate");
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.getByCurriculumVitaesId(sort, curriculumVitaesId));
	}

}
