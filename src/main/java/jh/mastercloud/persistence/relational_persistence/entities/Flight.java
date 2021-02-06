package jh.mastercloud.persistence.relational_persistence.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	private String flightCode;

	private String companyName;

	@Column(name = "flight_departure_datetime")
	private LocalDateTime flightDepartureDateTime;

	@Column(name = "flight_duration")
	private BigDecimal flightDuration;

	@ManyToOne
	private Plane plane;

//	private Airport departureAirport;
//	private Airport destinationAirport;
//	private Date flightDate;
//  private List<Crew> crew;
}
