package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.JobTypeService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.dataAccess.abstracts.JobTypeDao;
import myproject.hrms.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService {

	private JobTypeDao jobTypeDao;
	
	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		super();
		this.jobTypeDao = jobTypeDao;
	}

	@Override
	public DataResult<List<JobType>> getAll() {
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll(), "Data listelendi.");
	}

}
