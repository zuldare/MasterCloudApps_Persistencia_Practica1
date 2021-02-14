package jh.mastercloud.persistence.relational_persistence.repositories;

import java.util.List;
import jh.mastercloud.persistence.relational_persistence.dtos.mysql.NameSurnameCrew_DepartureDateTimeCity_ByCrewCodeDto;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {


	@Query("select new jh.mastercloud.persistence.relational_persistence.dtos.mysql.NameSurnameCrew_DepartureDateTimeCity_ByCrewCodeDto("
			+ "c.name, c.surname, a.city, f.flightDepartureDateTime) "
			+ " from Crew c, Flight f, Airport a "
			+ " where c.workerCode like :workerCode and f.departureAirport.id = a.id"
	)
	List<NameSurnameCrew_DepartureDateTimeCity_ByCrewCodeDto> findCrewDataDepartureInfoByWorkerCode(@Param("workerCode")String workerCode);

}
