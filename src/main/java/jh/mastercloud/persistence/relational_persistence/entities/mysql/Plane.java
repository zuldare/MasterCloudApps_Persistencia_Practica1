package jh.mastercloud.persistence.relational_persistence.entities.mysql;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plane")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Plane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "plate_number", unique = true, nullable = false)
	private String plateNumber;

	@NotBlank
	private String manufacturer;

	@NotNull
	private String model;

	@Column(name = "flight_hours", nullable = false)
	private BigDecimal flightHours;

}
