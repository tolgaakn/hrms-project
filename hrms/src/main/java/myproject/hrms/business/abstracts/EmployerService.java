package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.abstracts.User;
import myproject.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	DataResult<User> getByEmail(String email);
	
	Result add(Employer employer);
}
