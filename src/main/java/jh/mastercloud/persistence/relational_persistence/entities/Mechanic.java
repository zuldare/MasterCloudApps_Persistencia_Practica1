package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mechanic")
@Data
public class Mechanic extends Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "incorporation_year", nullable = false)
	private Integer incorporationYear;

	@NotNull
	private Training training;


	@Override
	public String toString(){
		return "[" + super.toString()
				+ ", " + this.training.toString()
				+ ", incorporationYear " + this.incorporationYear
				+ "]";
	}
}
