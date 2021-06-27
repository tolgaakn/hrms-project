package myproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import myproject.hrms.entities.concretes.AdvertisementConfirmByEmployee;
import myproject.hrms.entities.dtos.JobAdvertisementDto;

public interface AdvertisementConfirmByEmployeeDao extends JpaRepository<AdvertisementConfirmByEmployee, Integer> {
	AdvertisementConfirmByEmployee getByAdvertisementId(int advertisementId);
	
	@Query("Select new myproject.hrms.entities.dtos.JobAdvertisementDto(j.id, e.id, e.companyName, jp.position, j.openPosition, j.jobDescription, j.createdDate, j.applicationDeadline,"
			+ "j.minSalary, j.maxSalary, c.cityName, jt.jobTypeName, jt.jobTypeColor, w.workTypeName, w.workTypeColor) "
			+ "From JobAdvertisement j Inner Join j.employer e "
			+ "Inner Join j.jobPosition jp "
			+ "Inner Join j.city c "
			+ "Inner Join j.jobType jt "
			+ "Inner Join j.workType w "
			+ "Where j.isConfirmed=null")
	List<JobAdvertisementDto> getJobAdvertisementConfirmRequests();
}
