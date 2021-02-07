package jh.mastercloud.persistence.relational_persistence.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "begin_date")
	@NotNull
	private LocalDate beginDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "worked_hours", precision = 10, scale = 2)
	private BigDecimal workedHours;

	@Column(name = "review_type")
	@NotNull
	private ReviewType reviewType;

	@Column(name = "review_description")
	@NotBlank
	private String reviewDescription;

	@OneToOne
	@NotNull
	private Plane plane;

	@OneToOne
	@NotNull
	private Mechanic mechanic;

	@OneToOne
	@NotNull
	private Airport airport;
}
