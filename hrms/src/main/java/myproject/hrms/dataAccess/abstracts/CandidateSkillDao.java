package myproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.CandidateSkill;

public interface CandidateSkillDao extends JpaRepository<CandidateSkill, Integer> {

	List<CandidateSkill> getByCurriculumVitaeId(int curriculumVitaeId);
}
