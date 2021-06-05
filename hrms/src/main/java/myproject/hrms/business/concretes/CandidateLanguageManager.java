package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.CandidateLanguageService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.CandidateLanguageDao;
import myproject.hrms.entities.concretes.CandidateLanguage;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {

	private CandidateLanguageDao candidateLanguageDao;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
		super();
		this.candidateLanguageDao = candidateLanguageDao;
	}

	@Override
	public Result add(CandidateLanguage candidateLanguage) {
		this.candidateLanguageDao.save(candidateLanguage);
		return new SuccessResult("Dil becerisi eklendi.");
	}

	@Override
	public DataResult<List<CandidateLanguage>> getByCurriculumVitaesId(int curriculumVitaesId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "languageLevel");
		return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.getByCurriculumVitaesId(sort, curriculumVitaesId));
	}

}
