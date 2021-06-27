package myproject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "degrees")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidateEducations"})
public class Degree {

	@Id
	@Column(name = "id")
	private int Id;
	
	@Column(name = "degree_name")
	private String degreeName;
	
	@OneToMany(mappedBy = "degree")
	private List<CandidateEducation> candidateEducations;
}
