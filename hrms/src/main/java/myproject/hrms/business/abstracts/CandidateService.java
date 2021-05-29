package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.abstracts.User;
import myproject.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	
	DataResult<User> getByEmail(String email);
	
	DataResult<Candidate> findByNationalIdentity(String identityNumber);
	
	Result add(Candidate candidate);
}
