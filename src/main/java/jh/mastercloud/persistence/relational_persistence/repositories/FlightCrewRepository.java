package jh.mastercloud.persistence.relational_persistence.repositories;

import java.util.List;
import jh.mastercloud.persistence.relational_persistence.dtos.CrewNameSurnameSumFlighHoursTotalNumberFlightsDto;
import jh.mastercloud.persistence.relational_persistence.entities.FlightCrew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightCrewRepository extends JpaRepository<FlightCrew, Long> {

	@Query("select new jh.mastercloud.persistence.relational_persistence.dtos.CrewNameSurnameSumFlighHoursTotalNumberFlightsDto(c.name, c.surname, count(fc.flight.id), sum(f.flightDuration))"
			+ " from FlightCrew fc, Flight f, Crew c"
			+ " where fc.flight.id = f.id and fc.crew.id = c.id group by (c.id)")
	 List<CrewNameSurnameSumFlighHoursTotalNumberFlightsDto> findCrewDataFlightCountFlightDurationSum();
}
//	Caused by: java.lang.IllegalArgumentException: org.hibernate.hql.internal.ast.QuerySyntaxException:
//		Unable to locate appropriate constructor on class
//[jh.mastercloud.persistence.relational_persistence.dtos.CrewNameSurnameSumFlighHoursTotalNumberFlightsDto].
//		Expected arguments are: java.lang.String, java.lang.String, long, java.math.BigDecimal
//		[select new jh.mastercloud.persistence.relational_persistence.dtos.CrewNameSurnameSumFlighHoursTotalNumberFlightsDto
//		(c.name, c.surname, count(fc.flight.id), sum(f.flightDuration)) from jh.mastercloud.persistence.relational_persistence.entities.FlightCrew fc,
//		jh.mastercloud.persistence.relational_persistence.entities.Flight f, jh.mastercloud.persistence.relational_persistence.entities.Crew c where
//		fc.flight.id = f.id and fc.crew.id = c.id group by (c.id)]