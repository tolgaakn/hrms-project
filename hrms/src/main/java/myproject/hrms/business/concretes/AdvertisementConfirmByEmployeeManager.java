package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.AdvertisementConfirmByEmployeeService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.AdvertisementConfirmByEmployeeDao;
import myproject.hrms.entities.concretes.AdvertisementConfirmByEmployee;
import myproject.hrms.entities.concretes.JobAdvertisement;

@Service
public class AdvertisementConfirmByEmployeeManager implements AdvertisementConfirmByEmployeeService {

	private AdvertisementConfirmByEmployeeDao advertisementConfirmByEmplyoeeDao;
	
	@Autowired
	public AdvertisementConfirmByEmployeeManager(AdvertisementConfirmByEmployeeDao advertisementConfirmByEmplyoeeDao) {
		super();
		this.advertisementConfirmByEmplyoeeDao = advertisementConfirmByEmplyoeeDao;
	}

	@Override
	public DataResult<List<AdvertisementConfirmByEmployee>> getAll() {
		return new SuccessDataResult<List<AdvertisementConfirmByEmployee>>(this.advertisementConfirmByEmplyoeeDao.findAll());
	}

	@Override
	public Result activateAdvertisement(int advertisementId) {
		AdvertisementConfirmByEmployee advertisementConfirmByEmployee = advertisementConfirmByEmplyoeeDao.getByAdvertisementId(advertisementId);
		advertisementConfirmByEmployee.setIsConfirm(true);
		advertisementConfirmByEmplyoeeDao.save(advertisementConfirmByEmployee);
		return new SuccessResult("İş ilanı onaylandı.");
	}

	@Override
	public Result createActivationRequest(JobAdvertisement jobAdvertisement) {
		AdvertisementConfirmByEmployee advertisementConfirmByEmployee = new AdvertisementConfirmByEmployee();
		advertisementConfirmByEmployee.setAdvertisementId(jobAdvertisement.getId());
		advertisementConfirmByEmployee.setIsConfirm(false);
		advertisementConfirmByEmployee.setEmployeeId(27);
		advertisementConfirmByEmplyoeeDao.save(advertisementConfirmByEmployee);
		return new SuccessResult("İş ilanınız sistem personeli tarafından onaylanacaktır.");
	}

}
