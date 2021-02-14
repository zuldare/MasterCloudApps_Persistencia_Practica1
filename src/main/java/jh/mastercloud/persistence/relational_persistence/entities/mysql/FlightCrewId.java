package jh.mastercloud.persistence.relational_persistence.entities.mysql;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightCrewId implements Serializable {
	// implements serializable is MANDATORY in order to enable embeddable ids

	private Long flightId;
	private Long crewId;
}
