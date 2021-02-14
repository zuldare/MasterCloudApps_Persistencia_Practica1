package jh.mastercloud.persistence.relational_persistence.dtos.mysql;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightByDestinationCityDto {

	private String flightCode;
	private String flightCompanyName;
	private LocalDateTime flightDepartureDateTime;
	private String airportName;
	private String airportCity;
}
