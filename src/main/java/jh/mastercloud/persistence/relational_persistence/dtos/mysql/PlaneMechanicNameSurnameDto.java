package jh.mastercloud.persistence.relational_persistence.dtos.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlaneMechanicNameSurnameDto {

	private String plateNumber;
	private String mechanicName;
	private String mechanicSurname;


	public PlaneMechanicNameSurnameDto(String plateNumber, String mechanicName, String mechanicSurname){
		this.mechanicName = mechanicName;
		this.mechanicSurname = mechanicSurname;
		this.plateNumber = plateNumber;
	}
}
