package jh.mastercloud.persistence.relational_persistence.dtos.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CrewFromFlightDto {
	private String name;
	private String surname;
	private String workerCode;
	private String jobPosition;
}
