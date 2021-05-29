package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.JobPositionService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.ErrorResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.JobPositionDao;
import myproject.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "İş pozisyonları listelendi.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (getByJobPosition(jobPosition.getPosition()).getData() !=null) {
			return new ErrorResult("Bu iş pozisyonu zaten sistemde kayıtlı.");
		}else {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult(jobPosition.getPosition() + " sisteme eklendi.");
		}
	}

	@Override
	public DataResult<JobPosition> getByJobPosition(String jobPosition) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByPosition(jobPosition));
	}

}
