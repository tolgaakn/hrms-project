package myproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import myproject.hrms.entities.concretes.JobAdvertisement;
import myproject.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	JobAdvertisement findByIdEquals(int positionId);
	
	@Query("Select new myproject.hrms.entities.dtos.JobAdvertisementDto(j.id, e.id, e.companyName, jp.position, j.openPosition, j.jobDescription, j.createdDate, j.applicationDeadline, j.minSalary, j.maxSalary, c.cityName, jt.jobTypeName, jt.jobTypeColor, w.workTypeName, w.workTypeColor) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.jobPosition jp Inner Join j.city c Inner Join j.jobType jt Inner Join j.workType w Where j.id=:advertisementId")
	JobAdvertisementDto getById(int advertisementId);
	
	@Query("Select new myproject.hrms.entities.dtos.JobAdvertisementDto(j.id, e.id, e.companyName, jp.position, j.openPosition, j.jobDescription, j.createdDate, j.applicationDeadline, j.minSalary, j.maxSalary, c.cityName, jt.jobTypeName, jt.jobTypeColor, w.workTypeName, w.workTypeColor) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.jobPosition jp Inner Join j.city c Inner Join j.jobType jt Inner Join j.workType w Where j.isActive=?1 And j.isConfirmed=true")
	List<JobAdvertisementDto> getJobAdvertisementDetails(Sort sort, Boolean isActive);
	
	@Query("Select new myproject.hrms.entities.dtos.JobAdvertisementDto(j.id, e.id, e.companyName, jp.position, j.openPosition, j.jobDescription, j.createdDate, j.applicationDeadline, j.minSalary, j.maxSalary, c.cityName, jt.jobTypeName, jt.jobTypeColor, w.workTypeName, w.workTypeColor) "
			+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.jobPosition jp Inner Join j.city c Inner Join j.jobType jt Inner Join j.workType w Where j.isActive=?1 And j.isConfirmed=true")
	List<JobAdvertisementDto> getJobAdvertisementDetails(Boolean isActive);
	
	@Transactional
	@Modifying
	@Query("UPDATE myproject.hrms.entities.concretes.JobAdvertisement SET isActive = false WHERE id=:jobAdvertisementId AND employer.id=:employerId")
	void updateDeactiveJobAdvertisement(@Param("jobAdvertisementId") int jobAdvertisementId, @Param("employerId") int employerId);
	
	@Transactional
	@Modifying
	@Query("UPDATE myproject.hrms.entities.concretes.JobAdvertisement SET isActive = false, isDeleted = true WHERE id=:jobAdvertisementId AND employer.id=:employerId")
	void delete(@Param("jobAdvertisementId") int jobAdvertisementId, @Param("employerId") int employerId);
}
