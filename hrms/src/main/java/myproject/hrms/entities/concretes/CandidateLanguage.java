package myproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_languages")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class CandidateLanguage {

	@Id
	@Column(name = "id")
	private int id;
	
	//@Column(name = "curriculum_vitaes_id")
	//private int curriculumVitaesId;
	
	@ManyToOne(targetEntity = CurriculumVitae.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "curriculum_vitaes_id", insertable = false, updatable = false)
	@JsonIgnore
	private CurriculumVitae curriculumVitae;
	
	@Column(name = "curriculum_vitaes_id")
	private int curriculumVitaesId;
	
	@Column(name = "language_name")
	private String languageName;
	
	@Column(name = "language_level")
	private int languageLevel;
}
