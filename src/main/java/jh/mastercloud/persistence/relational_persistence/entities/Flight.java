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
import lombok.Data;

@Entity
@Data
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String flightCode;

	private String companyName;

	@Column(name = "flight_departure_datetime", columnDefinition = "TIMESTAMP")
	private LocalDateTime flightDepartureDateTime;

	@Column(name = "flight_duration")
	private BigDecimal flightDuration;

	//	private Plane plane;
//	private Airport departureAirport;
//	private Airport destinationAirport;
//	private Date flightDate;
//  private List<Crew> crew;
}
