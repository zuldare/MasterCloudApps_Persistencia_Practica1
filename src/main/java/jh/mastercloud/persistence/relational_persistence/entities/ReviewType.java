package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ReviewType {

	@Column(name = "review_type")
	private String description;
}
