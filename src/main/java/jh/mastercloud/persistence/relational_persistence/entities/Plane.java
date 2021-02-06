package jh.mastercloud.persistence.relational_persistence.entities;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

	@Column(name = "plate_number")
	private String plateNumber;

	private String manufacturer;

	private String model;

	@Column(name = "flight_hours")
	private BigDecimal flightHours;


	@OneToMany(mappedBy = "plane")
	@ToString.Exclude
	private List<Flight> flights;


}
