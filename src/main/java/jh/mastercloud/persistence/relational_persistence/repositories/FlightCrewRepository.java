package jh.mastercloud.persistence.relational_persistence.repositories;

import jh.mastercloud.persistence.relational_persistence.entities.FlightCrew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightCrewRepository extends JpaRepository<FlightCrew, Long> {

}
