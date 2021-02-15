package jh.mastercloud.persistence.relational_persistence.dtos.mysql;

import lombok.Data;

@Data
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
