package jh.mastercloud.persistence.relational_persistence.repositories;

import java.util.List;
import jh.mastercloud.persistence.relational_persistence.dtos.CrewFromFlightDto;
import jh.mastercloud.persistence.relational_persistence.dtos.CrewNameSurnameSumFlighHoursTotalNumberFlightsDto;
import jh.mastercloud.persistence.relational_persistence.dtos.NameSurnameCrew_DepartureDateTimeCity_ByCrewCodeDto;
import jh.mastercloud.persistence.relational_persistence.entities.FlightCrew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightCrewRepository extends JpaRepository<FlightCrew, Long> {

	@Query("select new jh.mastercloud.persistence.relational_persistence.dtos.CrewNameSurnameSumFlighHoursTotalNumberFlightsDto(c.name, c.surname, count(fc.flight.id), sum(f.flightDuration))"
			+ " from FlightCrew fc, Flight f, Crew c"
			+ " where fc.flight.id = f.id and fc.crew.id = c.id group by (c.id)")
	 List<CrewNameSurnameSumFlighHoursTotalNumberFlightsDto> findCrewDataFlightCountFlightDurationSum();


	@Query("select new jh.mastercloud.persistence.relational_persistence.dtos.CrewFromFlightDto(c.name, c.surname, c.workerCode, c.jobPosition)"
			+ " from FlightCrew fc, Crew c where fc.flight.id = :flightId and fc.crew.id = c.id")
	List<CrewFromFlightDto> findCrewFromFlight(@Param("flightId") Long flightId);

}
