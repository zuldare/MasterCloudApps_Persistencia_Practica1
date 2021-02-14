package jh.mastercloud.persistence.relational_persistence.repositories;

import jh.mastercloud.persistence.relational_persistence.entities.mysql.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {

}
