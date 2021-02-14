package jh.mastercloud.persistence.relational_persistence.entities.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "airport")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "iata_code", length = 3, nullable = false)
	private String iataCode;

	@NotBlank
	private String name;

	@NotBlank
	private String city;

	@NotBlank
	private String country;
}
