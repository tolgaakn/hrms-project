package myproject.hrms.business.concretes;

import java.util.UUID;

import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.ActivationCodeService;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.ActivationCodeDao;
import myproject.hrms.dataAccess.abstracts.UserDao;
import myproject.hrms.entities.abstracts.User;
import myproject.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService {

	private ActivationCodeDao activationCodeDao;
	private UserDao userDao;
	
	
	public ActivationCodeManager(ActivationCodeDao activationCodeDao, UserDao userDao) {
		super();
		this.activationCodeDao = activationCodeDao;
		this.userDao = userDao;
	}

	@Override
	public String createActivationCode(User user) {
		UUID uuid = UUID.randomUUID();
		
		ActivationCode activationCode = new ActivationCode();
		activationCode.setUserId(user.getId());
		activationCode.setActivationCode(uuid.toString());
		activationCode.setIsActivated(false);
		activationCodeDao.save(activationCode);
		
		return uuid.toString();
		
	}

	@Override
	public Result activateUser(String activationCode) {
		User user = userDao.getOne(activationCodeDao.findByActivationCode(activationCode).getUserId());
		user.setIsMailVerify(true);
		ActivationCode activationCode2 = activationCodeDao.findByActivationCode(activationCode);
		activationCode2.setIsActivated(true);
		userDao.save(user);
		activationCodeDao.save(activationCode2);
		return new SuccessResult("Kullanıcı aktivasyonu gerçekleşti");
		
	}

	@Override
	public ActivationCode getByCode(String activationCode) {
		return this.activationCodeDao.findByActivationCode(activationCode);
	}

}
