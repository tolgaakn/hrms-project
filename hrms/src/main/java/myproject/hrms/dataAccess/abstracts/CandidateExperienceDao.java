package myproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer> {

	List<CandidateExperience> getByCurriculumVitaesId(Sort sort, int curriculumVitaesId);
}
