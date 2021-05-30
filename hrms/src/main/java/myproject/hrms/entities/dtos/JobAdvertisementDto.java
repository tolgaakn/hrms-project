package myproject.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private String companyName;
	private String position;
	private int open_position;
	private LocalDateTime created_date;
	private String applicationDeadline;
}
