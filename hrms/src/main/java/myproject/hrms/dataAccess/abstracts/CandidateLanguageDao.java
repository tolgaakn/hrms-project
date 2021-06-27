package myproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer> {

	List<CandidateLanguage> getByCurriculumVitaeId(Sort sort, int curriculumVitaesId);
}
