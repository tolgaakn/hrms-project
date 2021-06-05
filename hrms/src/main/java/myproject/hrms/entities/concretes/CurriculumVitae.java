package myproject.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_vitaes")
@Entity
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "candidate_id")
	private int candidateId;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "candidate_cover_letter_id")
	private int candidateCoverLetterId;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateEducation> candidateEducations;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateExperience> candidateExperiences;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateSkill> candidateSkills;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CandidateLanguage> candidateLanguages;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CoverLetter> coverLetters;
}
