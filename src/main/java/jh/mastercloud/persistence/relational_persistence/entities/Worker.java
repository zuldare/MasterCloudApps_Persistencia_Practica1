package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "worker_code")
	@NotBlank
	private String workerCode;

	@Column(name = "name")
	@NotBlank
	private String name;

	@Column(name = "surname")
	@NotBlank
	private String surname;

	@Column(name = "company_name")
	@NotBlank
	private String companyName;
}
