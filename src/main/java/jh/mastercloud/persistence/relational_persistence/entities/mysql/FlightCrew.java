package jh.mastercloud.persistence.relational_persistence.entities.mysql;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flight_crew")
@Data
@NoArgsConstructor
public class FlightCrew {

	@EmbeddedId
	private FlightCrewId id;

	@ManyToOne
	@MapsId("flightId")
	@NotNull
	private Flight flight;

	@ManyToOne
	@MapsId("crewId")
	@NotNull
	private Crew crew;

	public FlightCrew(Flight flight, Crew crew){
		this.flight = flight;
		this.crew = crew;
		this.id = new FlightCrewId(flight.getId(), crew.getId());
	}
}
