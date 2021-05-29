package myproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

	JobPosition findByPosition(String jobPosition);
}
