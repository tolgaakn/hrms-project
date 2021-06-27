package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.AdvertisementConfirmByEmployee;
import myproject.hrms.entities.concretes.JobAdvertisement;
import myproject.hrms.entities.dtos.JobAdvertisementDto;

public interface AdvertisementConfirmByEmployeeService {
	
	DataResult<List<AdvertisementConfirmByEmployee>> getAll();
	
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementConfirmRequests();
	
	Result createActivationRequest(JobAdvertisement jobAdvertisement);
	
	Result activateAdvertisement(int advertisementId, int employeeId);
	
	Result rejectAdvertisement(int advertisementId, int employeeId);
}
