package jh.mastercloud.persistence.relational_persistence.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "begin_date", columnDefinition = "DATE")
	private LocalDate beginDate;

	@Column(name = "end_date", columnDefinition = "DATE")
	private LocalDate endDate;

	@Column(name = "worked_hours")
	private BigDecimal workedHours;

	@Column(name = "review_type")
	private ReviewType reviewType;

	private String description;

	// private Plane plane;
	// private Mechanic mechanic;
	// private Airplane airplane;
}
