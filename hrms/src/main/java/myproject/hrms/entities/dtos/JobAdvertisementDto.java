package myproject.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int id;
	private int employerId;
	private String companyName;
	private String position;
	private int openPosition;
	private String jobDescription;
	private Date createdDate;
	private Date applicationDeadline;
	private int minSalary;
	private int maxSalary;
	private String cityName;
	private String jobTypeName;
	private String jobTypeColor;
	private String workTypeName;
	private String workTypeColor;
}
