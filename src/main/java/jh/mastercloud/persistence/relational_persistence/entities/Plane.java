package jh.mastercloud.persistence.relational_persistence.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Plane {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "plate_number")
	private String plateNumber;

	private String manufacturer;

	private String model;

	@Column(name = "flight_hours")
	private BigDecimal flightHours;

}
