package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Training {

  @Column(name = "training_description")
	private String trainingDescription;
}
