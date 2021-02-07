package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mechanic")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mechanic extends Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "incorporation_year", nullable = false)
	private Integer incorporationYear;

	@NotNull
	private Training training;

	@Builder
	public Mechanic(String workerCode, String name, String surname, String companyName, Training training, Integer incorporationYear){
		this.setWorkerCode(workerCode);
		this.setName(name);
		this.setSurname(surname);
		this.setCompanyName(companyName);
		this.setTraining(training);
		this.incorporationYear = incorporationYear;
	}

	@Override
	public String toString(){
		return "[" + super.toString()
				+ ", " + this.training.toString()
				+ ", incorporationYear " + this.incorporationYear
				+ "]";
	}
}
