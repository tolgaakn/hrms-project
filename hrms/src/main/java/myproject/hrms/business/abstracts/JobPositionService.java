package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	
	DataResult<JobPosition> getByJobPosition(String jobPosition);
	
	Result add(JobPosition jobPosition);
}
