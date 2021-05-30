package myproject.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.JobAdvertisementService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.ErrorResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.JobAdvertisementDao;
import myproject.hrms.entities.concretes.JobAdvertisement;
import myproject.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper modelMapper) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper = modelMapper;
	}

	private List<JobAdvertisementDto> dtoGenerator(List<JobAdvertisement> adding){
		List<JobAdvertisementDto> jobAdvertisementDtos = new ArrayList<JobAdvertisementDto>();
		adding.forEach(item ->{
			JobAdvertisementDto dto = this.modelMapper.map(item, JobAdvertisementDto.class);
			dto.setCompanyName(item.getEmployer().getCompanyName());
			jobAdvertisementDtos.add(dto);
		});
		return jobAdvertisementDtos;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if (
				jobAdvertisement.getJobPosition() != null || 
				jobAdvertisement.getJobDescription() != null || 
				jobAdvertisement.getCity() != null || 
				jobAdvertisement.getOpenPosition() > 0) {
			
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult(jobAdvertisement.getJobPosition() + " ilanınız başarıyla eklendi.");
			
		}
		
		return new ErrorResult("Hatalı giriş yaptınız");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoGenerator(this.jobAdvertisementDao.findByIsActive(true)));
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoGenerator(this.jobAdvertisementDao.findByIsActiveOrderByApplicationDeadline(true)));
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoGenerator(this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(true, companyName)));
	}

	@Override
	public Result delete(int id) {
		JobAdvertisement jobAdvertisement = jobAdvertisementDao.getOne(id);
		jobAdvertisement.setIsActive(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan başarıyla silindi.");
	}

	
}
