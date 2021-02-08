package jh.mastercloud.persistence.relational_persistence.dtos;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CrewNameSurnameSumFlighHoursTotalNumberFlightsDto {

	private String name;
	private String surname;
	private Long flightCount;
	private BigDecimal flightDurationSum;
}
