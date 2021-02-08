package jh.mastercloud.persistence.relational_persistence.dtos;

import java.time.LocalDateTime;
import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.javatuples.Pair;
import org.javatuples.Tuple;

@Data
@AllArgsConstructor
public class NameSurnameCrew_DepartureDateTimeCity_ByCrewCodeDto {

	private String name;
	private String surname;
	private String city;
	private LocalDateTime departureDateTime;


//	@Override
//	public String toString(){
//		return "NameSurnameCrew_DepartureDateTimeCity_ByCrewCodeDto("
//		 	+ "name= " + name  + ", surname= " + surname
//			+ ", city" + city
//			+ ", departureDateTime " + departureDateTime.toString();
//
//
//	}

}
