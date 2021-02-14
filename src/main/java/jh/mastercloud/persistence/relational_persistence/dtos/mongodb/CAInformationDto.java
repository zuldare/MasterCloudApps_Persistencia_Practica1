package jh.mastercloud.persistence.relational_persistence.dtos.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CAInformationDto {

	private String id;
	private Integer total;

	@Override
	public String toString(){
		return "CAInformation{id=" + this.id + ", total=" + this.total + "}";
	}
}
