package myproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {

}
