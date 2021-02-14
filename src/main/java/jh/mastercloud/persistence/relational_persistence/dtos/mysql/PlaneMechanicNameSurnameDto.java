package jh.mastercloud.persistence.relational_persistence.dtos.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaneMechanicNameSurnameDto {

	private String plateNumber;
	private String mechanicName;
	private String mechanicSurname;

}
