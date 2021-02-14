package jh.mastercloud.persistence.relational_persistence.entities.mongodb;

import java.util.List;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("provincias")
public class Province {
	@Id
	private String id;

	@Field("Nombre")
	private String name;

	@Field("CA")
	private String ca;

	@Field("Superficie")
	private String area;

	@Field("Datos")
	private List<PopulationYear> populationYears;

	@Override
	public String toString(){
			return "Province{ id= " + this.id + ", "
					+ "name=" + this.name + ", "
					+ "CA=" + this.ca + ", "
					+ "area=" + this.area + ", "
					+ "populationYears" + this.populationYears + "}";
	}
}
