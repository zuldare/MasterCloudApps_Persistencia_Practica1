package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Crew extends Worker {

	@Column(name = "job_position")
	private JobPosition jobPosition;

	@Override
	public String toString(){
		return "[ " + super.toString() + ", " + this.jobPosition.toString() + " ]";
	}
}
