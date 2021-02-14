package jh.mastercloud.persistence.relational_persistence.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "flight")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "flight_code", nullable = false)
	private String flightCode;

	@Column(name = "company_name", nullable = false)
	private String companyName;

	@Column(name = "flight_departure_datetime")
	@NotNull
	private LocalDateTime flightDepartureDateTime;

	@Column(name = "flight_duration")
	@NotNull
	private BigDecimal flightDuration;

	@OneToOne
	@NotNull
	private Plane plane;

	@OneToOne
	@NotNull
	@JoinColumn(name = "departure_airport_id")
	private Airport departureAirport;

	@OneToOne
	@NotNull
	@JoinColumn(name = "destination_airport_id")
	private Airport destinationAirport;

	@ToString.Exclude
	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FlightCrew> crewList;
}
