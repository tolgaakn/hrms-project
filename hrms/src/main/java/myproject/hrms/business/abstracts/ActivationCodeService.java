package myproject.hrms.business.abstracts;

import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.abstracts.User;
import myproject.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {
	
	String createActivationCode(User user);
	
	Result activateUser(String activationCode);
	
	ActivationCode getByCode(String activationCode);
}
