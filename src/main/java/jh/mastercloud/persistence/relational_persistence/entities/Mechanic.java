package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Mechanic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "worker_code")
	private String workerCode;

	private String name;

	private String surname;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "incorporation_date")
	private Integer incorporationDate;

	private Training training;
}
