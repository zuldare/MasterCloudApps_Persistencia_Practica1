package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
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
}
