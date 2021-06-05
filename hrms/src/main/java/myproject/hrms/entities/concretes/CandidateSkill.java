package myproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_skills")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class CandidateSkill {

	@Id
	@Column(name = "id")
	private int id;
	
	//@Column(name = "curriculum_vitaes_id")
	//private int curriculumVitaesId;
	
	@ManyToOne
	@JoinColumn(name = "curriculum_vitaes_id")
	private CurriculumVitae curriculumVitae;
	
	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;
	
	//@Column(name = "skill_id")
	//private int skillId;
}
