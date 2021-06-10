package myproject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_types")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class JobType {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_type_name")
	private String jobTypeName;
	
	@Column(name = "job_type_color")
	private String jobTypeColor;
	
	@OneToMany(mappedBy = "jobType")
	private List<JobAdvertisement> jobAdvertisements;
}
