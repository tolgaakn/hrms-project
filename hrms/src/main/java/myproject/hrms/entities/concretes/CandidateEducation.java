package myproject.hrms.entities.concretes;

import java.util.Date;

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
@Table(name = "candidate_educations")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class CandidateEducation {

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
	
	@Column(name = "university_name")
	private String universityName;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "degree")
	private String degree;
	
	@Column(name = "started_date")
	private Date startedDate;
	
	@Column(name = "graduated_date")
	private Date graduatedDate;
}
