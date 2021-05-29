package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.ConfirmByEmployee;
import myproject.hrms.entities.concretes.Employer;

public interface ConfirmByEmployeeService {
	
	DataResult<List<ConfirmByEmployee>> getAll();
	
	Result createActivationRequest(Employer employer);
	
	Result activateEmployer(int employerId);
}
