package jh.mastercloud.persistence.relational_persistence.entities.mongodb;

import org.springframework.data.mongodb.core.mapping.Field;

public class PopulationYear {

	  @Field("Anyo")
	  private Integer year;

	  @Field("Valor")
	  private Integer population;

		@Override
		public String toString(){
				return "PopulationYear{year=" + this.year + ", " + "population=" + this.population + "}";
		}
}
