package jh.mastercloud.persistence.relational_persistence.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "crew")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Crew extends Worker {

	@Column(name = "job_position")
	@NotNull
	private String jobPosition;

	@ToString.Exclude
	@OneToMany(mappedBy = "crew", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<FlightCrew> flightCrewList;

	@Builder
	public Crew(String workerCode, String name, String surname, String companyName, String jobPosition){
		this.setWorkerCode(workerCode);
		this.setName(name);
		this.setSurname(surname);
		this.setCompanyName(companyName);
		this.setJobPosition(jobPosition);
	}

	@Override
	public String toString(){
		return "[" + super.toString()
				+ ", job= " + this.jobPosition.toString()
				+ "]";
	}
}
