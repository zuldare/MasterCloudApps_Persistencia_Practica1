package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Training {

	private String description;
}
