package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "worker_code")
	private String workerCode;

	@Column(name = "name")
	private String name;

	@Column(name = "surnames")
	private String surnames;

	@Column(name = "company_name")
	private String companyName;
}
