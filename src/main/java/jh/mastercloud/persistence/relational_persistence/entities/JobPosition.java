package jh.mastercloud.persistence.relational_persistence.entities;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {

	private String jobDescription;
}
