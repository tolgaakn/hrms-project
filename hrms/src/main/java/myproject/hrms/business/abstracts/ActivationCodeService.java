package myproject.hrms.business.abstracts;

import myproject.hrms.core.entities.User;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {
	
	String createActivationCode(User user);
	
	Result activateUser(String activationCode);
	
	ActivationCode getByCode(String activationCode);
}
