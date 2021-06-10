package myproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.JobType;

public interface JobTypeDao extends JpaRepository<JobType, Integer> {

}
