package jh.mastercloud.persistence.relational_persistence.repositories;

import java.time.LocalDate;
import java.util.List;
import jh.mastercloud.persistence.relational_persistence.dtos.FlightByDestinationCityDto;
import jh.mastercloud.persistence.relational_persistence.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {


	@Query("select new jh.mastercloud.persistence.relational_persistence.dtos.FlightByDestinationCityDto(f.flightCode, f.companyName, f.flightDepartureDateTime, a.city, a.name) "
			+ " from Airport a, Flight f "
			+	" where lower(a.city) like lower(:cityName)  "
			+ " and  DATE_FORMAT(f.flightDepartureDateTime, '%Y-%m-%d') = :arrivalDate "
			+	" and f.destinationAirport.id  = a.id ORDER BY f.flightDepartureDateTime"
	)
	List<FlightByDestinationCityDto> findFlightsGivenCityAndDateOrderedByDepartureDateTime(@Param("cityName")String cityName, @Param("arrivalDate") String arrivalDate);
}
