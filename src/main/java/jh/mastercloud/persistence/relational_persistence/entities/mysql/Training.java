package jh.mastercloud.persistence.relational_persistence.entities.mysql;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Training {

  @Column(name = "training_description")
	private String trainingDescription;
}
