package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
