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
@Table(name = "work_types")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class WorkType {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "work_type_name")
	private String workTypeName;
	
	@Column(name = "work_type_color")
	private String workTypeColor;
	
	@OneToMany(mappedBy = "workType")
	private List<JobAdvertisement> jobAdvertisements;
}
