package jh.mastercloud.persistence.relational_persistence.repositories;

import java.util.List;
import jh.mastercloud.persistence.relational_persistence.dtos.PlaneMechanicNameSurnameDto;
import jh.mastercloud.persistence.relational_persistence.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


	@Query("select distinct new jh.mastercloud.persistence.relational_persistence.dtos.PlaneMechanicNameSurnameDto(p.plateNumber, m.name, m.surname) "
			+ " from Review r, Plane p, Mechanic m "
			+ " where p.id = r.plane.id and m.id = r.mechanic.id")
	List<PlaneMechanicNameSurnameDto> findMechanicNameSurnameOfReviewedPlanesWithSubQuery();


	@Query("select distinct new jh.mastercloud.persistence.relational_persistence.dtos.PlaneMechanicNameSurnameDto(p.plateNumber, m.name, m.surname) "
		+ " from Review r "
		+ " JOIN Plane p on p.id = r.plane.id"
		+ " JOIN Mechanic m on m.id = r.mechanic.id")
	List<PlaneMechanicNameSurnameDto> findMechanicNameSurnameOfReviewedPlanesWithJoins();
}
