package jh.mastercloud.persistence.relational_persistence.repositories;

import javax.persistence.Entity;
import jh.mastercloud.persistence.relational_persistence.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
