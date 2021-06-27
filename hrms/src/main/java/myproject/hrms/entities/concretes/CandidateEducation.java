package myproject.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "candidate_educations")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class CandidateEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = CurriculumVitae.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "curriculum_vitae_id", insertable = false, updatable = false)
	@JsonIgnore
	private CurriculumVitae curriculumVitae;
	
	@Column(name = "curriculum_vitae_id")
	private int curriculumVitaeId;
	
	@Column(name = "university_name")
	private String universityName;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@ManyToOne
	@JoinColumn(name = "degree_id")
	private Degree degree;
	
	@Column(name = "started_date")
	private Date startedDate;
	
	@Column(name = "graduated_date")
	private Date graduatedDate;
}
