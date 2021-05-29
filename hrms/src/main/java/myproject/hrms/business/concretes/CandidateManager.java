package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.ActivationCodeService;
import myproject.hrms.business.abstracts.CandidateService;
import myproject.hrms.core.adapters.EmailValidator;
import myproject.hrms.core.adapters.MernisDemo;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.ErrorResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.CandidateDao;
import myproject.hrms.dataAccess.abstracts.UserDao;
import myproject.hrms.entities.abstracts.User;
import myproject.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserDao userDao;
	private ActivationCodeService activationCodeService;
	private MernisDemo mernisDemo;
	private EmailValidator emailValidator;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao, MernisDemo mernisDemo, EmailValidator emailValidator, ActivationCodeService activationCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.activationCodeService = activationCodeService;
		this.mernisDemo = mernisDemo;
		this.emailValidator = emailValidator;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Tüm adaylar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		
		if (candidate.getPassword().length()<8) {
			
			return new ErrorResult("Şifre en az 8 karakterli olmalıdır.");
			
		}else if(!emailValidator.isEmailValid(candidate.getEmail())) {
			
			return new ErrorResult("Lütfen geçerli bir email adresi girin.");
			
		}else if(getByEmail(candidate.getEmail()).getData() != null) {
			
			return new ErrorResult("Girdiğiniz email adresi sistemde zaten kayıtlı.");
			
		}else if(findByNationalIdentity(candidate.getNationalIdentity()).getData() != null) {
			
			return new ErrorResult("Girdiğiniz kimlik numarası sistemde zaten kayıtlı.");
			
		}else if(mernisDemo.isValidNationalIdentity(candidate.getNationalIdentity())) {
			
			candidate.setIsMailVerify(false);
			this.candidateDao.save(candidate);
			this.activationCodeService.createActivationCode(candidate);
			return new SuccessResult("Başarıyla kayıt olundu.");
		}else {
			return new ErrorResult("Kullanıcı bilgileri hatalı.");
		}
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}

	@Override
	public DataResult<Candidate> findByNationalIdentity(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalIdentity(identityNumber));
	}
	
	
	

}
