package myproject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidateSkills"})
public class Skill {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "skill_name")
	private String skillName;
	
	@OneToMany(mappedBy = "skill")
	private List<CandidateSkill> candidateSkills;
}