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
import myproject.hrms.dataAccess.abstracts.JobAdvertisementDao;
import myproject.hrms.entities.concretes.AdvertisementConfirmByEmployee;
import myproject.hrms.entities.concretes.JobAdvertisement;
import myproject.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class AdvertisementConfirmByEmployeeManager implements AdvertisementConfirmByEmployeeService {

	private AdvertisementConfirmByEmployeeDao advertisementConfirmByEmplyoeeDao;
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public AdvertisementConfirmByEmployeeManager(AdvertisementConfirmByEmployeeDao advertisementConfirmByEmplyoeeDao, JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.advertisementConfirmByEmplyoeeDao = advertisementConfirmByEmplyoeeDao;
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<AdvertisementConfirmByEmployee>> getAll() {
		return new SuccessDataResult<List<AdvertisementConfirmByEmployee>>(this.advertisementConfirmByEmplyoeeDao.findAll());
	}

	

	@Override
	public Result createActivationRequest(JobAdvertisement jobAdvertisement) {
		AdvertisementConfirmByEmployee advertisementConfirmByEmployee = new AdvertisementConfirmByEmployee();
		advertisementConfirmByEmployee.setAdvertisementId(jobAdvertisement.getId());
		advertisementConfirmByEmployee.setIsConfirm(false);
		advertisementConfirmByEmplyoeeDao.save(advertisementConfirmByEmployee);
		return new SuccessResult("İş ilanınız sistem personeli tarafından onaylanacaktır.");
	}

	@Override
	public Result activateAdvertisement(int advertisementId, int employeeId) {
		JobAdvertisement jobAdvertisement = jobAdvertisementDao.getOne(advertisementId);
		jobAdvertisement.setIsConfirmed(true);
		
		AdvertisementConfirmByEmployee advertisementConfirmByEmployee = advertisementConfirmByEmplyoeeDao.getByAdvertisementId(advertisementId);
		advertisementConfirmByEmployee.setEmployeeId(employeeId);
		advertisementConfirmByEmployee.setIsConfirm(true);
		
		jobAdvertisementDao.save(jobAdvertisement);
		advertisementConfirmByEmplyoeeDao.save(advertisementConfirmByEmployee);
		return new SuccessResult("İlan onaylandı.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementConfirmRequests() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.advertisementConfirmByEmplyoeeDao.getJobAdvertisementConfirmRequests());
	}

	@Override
	public Result rejectAdvertisement(int advertisementId, int employeeId) {
		JobAdvertisement jobAdvertisement = jobAdvertisementDao.getOne(advertisementId);
		jobAdvertisement.setIsConfirmed(false);
		jobAdvertisement.setIsActive(false);
		
		AdvertisementConfirmByEmployee advertisementConfirmByEmployee = advertisementConfirmByEmplyoeeDao.getByAdvertisementId(advertisementId);
		advertisementConfirmByEmployee.setEmployeeId(employeeId);
		advertisementConfirmByEmployee.setIsConfirm(false);
		
		jobAdvertisementDao.save(jobAdvertisement);
		advertisementConfirmByEmplyoeeDao.save(advertisementConfirmByEmployee);
		return new SuccessResult("İlan reddedildi.");
	}




}
