package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.CandidateSkillService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.CandidateSkillDao;
import myproject.hrms.entities.concretes.CandidateSkill;

@Service
public class CandidateSkillManager implements CandidateSkillService {

	private CandidateSkillDao candidateSkillDao;
	
	@Autowired
	public CandidateSkillManager(CandidateSkillDao candidateSkillDao) {
		super();
		this.candidateSkillDao = candidateSkillDao;
	}

	@Override
	public Result add(CandidateSkill candidateSkill) {
		this.candidateSkillDao.save(candidateSkill);
		return new SuccessResult("Yetenek eklendi.");
	}

	@Override
	public DataResult<List<CandidateSkill>> getByCurriculumVitaeId(int curriculumVitaeId) {
		return new SuccessDataResult<List<CandidateSkill>>(this.candidateSkillDao.getByCurriculumVitaeId(curriculumVitaeId));
	}

}
