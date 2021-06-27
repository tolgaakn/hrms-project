package myproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cover_letters")
@Entity
public class CoverLetter {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "cover_letter_name")
	private String coverLetterName;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
}
