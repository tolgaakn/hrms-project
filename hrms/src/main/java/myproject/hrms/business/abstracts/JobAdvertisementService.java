package myproject.hrms.business.abstracts;


import java.util.List;


import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.JobAdvertisement;
import myproject.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisementDto>> getAllSortedAscByIsActive();
	
	DataResult<List<JobAdvertisementDto>> getAllSortedDescByIsActive();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result delete(int jobAdvertisementId, int employerId);
	
	Result updateDeactiveJobAdvertisement(int jobAdvertisementId, int employerId);
	
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails(Boolean isActive);
	
	DataResult<JobAdvertisementDto> getById(int id);
	
	Result activateAdvertisement(int advertisementId);
}
