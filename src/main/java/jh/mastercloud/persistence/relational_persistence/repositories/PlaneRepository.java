package jh.mastercloud.persistence.relational_persistence.repositories;

import java.util.List;
import jh.mastercloud.persistence.relational_persistence.dtos.mysql.PlaneMechanicNameSurnameDto;
import jh.mastercloud.persistence.relational_persistence.dtos.mysql.PlaneMechanicNameSurnameInterfaceDto;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {


  @Query(value = "SELECT p.plate_number as plateNumber, m.name as mechanicName, m.surname as mechanicSurname  from plane p left join mechanic m "
			+ "on JSON_CONTAINS(JSON_EXTRACT(p.maintenances, '$[*].mechanic_id' ), CAST(m.id as JSON))=1", nativeQuery = true)
	List<PlaneMechanicNameSurnameInterfaceDto> findPlanesAndMechanicsByJSONField();


	@Query(value = "SELECT p.plate_number, m.name, m.surname  from plane p left join mechanic m "
			+ "on JSON_CONTAINS(JSON_EXTRACT(p.maintenances, '$[*].mechanic_id' ), CAST(m.id as JSON))=1", nativeQuery = true)
	List<PlaneMechanicNameSurnameDto> findPlanesAndMechanicsByJSONField2();

}
