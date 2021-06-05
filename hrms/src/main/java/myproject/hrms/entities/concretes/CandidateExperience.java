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
@Table(name = "candidate_experiences")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class CandidateExperience {

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
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "position_name")
	private String positionName;
	
	@Column(name = "started_date")
	private Date startedDate;
	
	@Column(name = "quit_date")
	private Date quitDate;
}
