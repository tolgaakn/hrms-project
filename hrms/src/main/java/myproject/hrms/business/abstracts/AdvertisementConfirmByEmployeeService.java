package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.AdvertisementConfirmByEmployee;
import myproject.hrms.entities.concretes.JobAdvertisement;

public interface AdvertisementConfirmByEmployeeService {
	
	DataResult<List<AdvertisementConfirmByEmployee>> getAll();
	
	Result createActivationRequest(JobAdvertisement jobAdvertisement);
	
	Result activateAdvertisement(int advertisementId);
}
