package myproject.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.AdvertisementConfirmByEmployeeService;
import myproject.hrms.business.abstracts.JobAdvertisementService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.ErrorResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.AdvertisementConfirmByEmployeeDao;
import myproject.hrms.dataAccess.abstracts.JobAdvertisementDao;
import myproject.hrms.entities.concretes.AdvertisementConfirmByEmployee;
import myproject.hrms.entities.concretes.Employer;
import myproject.hrms.entities.concretes.JobAdvertisement;
import myproject.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private AdvertisementConfirmByEmployeeDao advertisementConfirmByEmployeeDao;
	private AdvertisementConfirmByEmployeeService advertisementConfirmByEmployeeService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, AdvertisementConfirmByEmployeeDao advertisementConfirmByEmployeeDao, AdvertisementConfirmByEmployeeService advertisementConfirmByEmployeeService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.advertisementConfirmByEmployeeDao = advertisementConfirmByEmployeeDao;
		this.advertisementConfirmByEmployeeService = advertisementConfirmByEmployeeService;
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllSortedAscByIsActive() {
		Sort sort = Sort.by(Sort.Direction.ASC, "createdDate");
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetails(sort, true));
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> getAllSortedDescByIsActive() {
		Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetails(sort, true));
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if (
				jobAdvertisement.getJobPosition() != null || 
				jobAdvertisement.getJobDescription() != null || 
				jobAdvertisement.getCity() != null || 
				jobAdvertisement.getOpenPosition() > 0) {
			
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			
			jobAdvertisement.setCreatedDate(date);
			jobAdvertisement.setIsActive(true);
			jobAdvertisement.setIsDeleted(false);
			this.jobAdvertisementDao.save(jobAdvertisement);
			this.advertisementConfirmByEmployeeService.createActivationRequest(jobAdvertisement);
			return new SuccessResult(jobAdvertisement.getJobPosition() + " ilan??n??z ba??ar??yla eklendi.");
			
		}
		
		return new ErrorResult("Hatal?? giri?? yapt??n??z");
	}


	@Override
	public Result delete(int jobAdvertisementId, int employerId) {
		this.jobAdvertisementDao.delete(jobAdvertisementId, employerId);
		return new SuccessResult("??lan ba??ar??yla silindi.");
	}

	
	@Override
	public Result updateDeactiveJobAdvertisement(int jobAdvertisementId, int employerId) {
		this.jobAdvertisementDao.updateDeactiveJobAdvertisement(jobAdvertisementId, employerId);
		return new SuccessResult("??lan kald??r??ld??.");
	}

	
	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails(Boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetails(isActive), "Data listelendi.");
	}

	@Override
	public DataResult<JobAdvertisementDto> getById(int advertisementId) {
		return new SuccessDataResult<JobAdvertisementDto>(this.jobAdvertisementDao.getById(advertisementId));
	}

	@Override
	public Result activateAdvertisement(int advertisementId) {
		AdvertisementConfirmByEmployee advertisementConfirmByEmployee = advertisementConfirmByEmployeeDao.getByAdvertisementId(advertisementId);
		advertisementConfirmByEmployee.setIsConfirm(true);
		advertisementConfirmByEmployeeDao.save(advertisementConfirmByEmployee);
		return new SuccessResult("???? ilan?? onayland??.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByJobPositionIdAndCityId(int jobPositionId, int cityId) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetailsByJobPositionIdAndCityId(jobPositionId, cityId));
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByIsConfirmed(Boolean isConfirmed) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetailsByIsConfirmed(isConfirmed));
	}

}
