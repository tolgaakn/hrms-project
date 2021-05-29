package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.ConfirmByEmployeeService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.ConfirmByEmployeeDao;
import myproject.hrms.entities.concretes.ConfirmByEmployee;
import myproject.hrms.entities.concretes.Employer;

@Service
public class ConfirmByEmployeeManager implements ConfirmByEmployeeService {

	private ConfirmByEmployeeDao confirmByEmployeeDao;
	
	public ConfirmByEmployeeManager(ConfirmByEmployeeDao confirmByEmployeeDao) {
		super();
		this.confirmByEmployeeDao = confirmByEmployeeDao;
	}

	@Override
	public DataResult<List<ConfirmByEmployee>> getAll() {
		return new SuccessDataResult<List<ConfirmByEmployee>>(this.confirmByEmployeeDao.findAll());
	}
	
	@Override
	public Result createActivationRequest(Employer employer) {
		ConfirmByEmployee confirmByEmployee = new ConfirmByEmployee();
		confirmByEmployee.setEmployerId(employer.getId());
		confirmByEmployee.setIsConfirm(false);
		confirmByEmployeeDao.save(confirmByEmployee);
		return new SuccessResult("Kaydınız sistem personeli tarafından onaylanacaktır.");
	}

	@Override
	public Result activateEmployer(int employerId) {
		ConfirmByEmployee confirmByEmployee = confirmByEmployeeDao.findByEmployerId(employerId);
		confirmByEmployee.setIsConfirm(true);
		confirmByEmployeeDao.save(confirmByEmployee);
		return new SuccessResult("İşveren onaylandı.");
	}

}
