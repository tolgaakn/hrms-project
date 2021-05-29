package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.ActivationCodeService;
import myproject.hrms.business.abstracts.ConfirmByEmployeeService;
import myproject.hrms.business.abstracts.EmployerService;
import myproject.hrms.core.adapters.EmailValidator;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.ErrorResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.EmployerDao;
import myproject.hrms.dataAccess.abstracts.UserDao;
import myproject.hrms.entities.abstracts.User;
import myproject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;
	private ActivationCodeService activationCodeService;
	private ConfirmByEmployeeService confirmByEmployeeService;
	private EmailValidator emailValidator;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailValidator emailValidator, UserDao userDao, ActivationCodeService activationCodeService, ConfirmByEmployeeService confirmByEmployeeService) {
		super();
		this.employerDao = employerDao;
		this.emailValidator = emailValidator;
		this.userDao = userDao;
		this.activationCodeService = activationCodeService;
		this.confirmByEmployeeService = confirmByEmployeeService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İşverenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		if (!emailValidator.isEmailMatchesWebAddress(employer.getEmail(), employer.getWebAddress())) {
			return new ErrorResult("E-posta adresiniz web adresinizle eşleşmiyor.");
		}else if(getByEmail(employer.getEmail()).getData() != null) {
			return new ErrorResult("Girdiğiniz e-posta adresi zaten kayıtlı.");
		}else {
			employer.setIsMailVerify(false);
			this.employerDao.save(employer);
			this.activationCodeService.createActivationCode(employer);
			this.confirmByEmployeeService.createActivationRequest(employer);
			return new SuccessResult(employer.getEmail() + " adresine doğrulama kodu gönderildi.");
		}
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}
	
	

}
