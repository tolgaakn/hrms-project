package myproject.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer> {
	
	List<CandidateEducation> getByCurriculumVitaesId(Sort sort, int curriculumVitaesId);
}
