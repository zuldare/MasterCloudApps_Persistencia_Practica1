package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "crew")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Crew extends Worker {

	@Column(name = "job_position")
	@NotNull
	private JobPosition jobPosition;

	@Override
	public String toString(){
		return "[ " + super.toString() + ", " + this.jobPosition.toString() + " ]";
	}
}
