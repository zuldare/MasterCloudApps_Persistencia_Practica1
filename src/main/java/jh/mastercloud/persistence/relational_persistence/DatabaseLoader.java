package jh.mastercloud.persistence.relational_persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	private final DataBasePopulator dataBasePopulator;

	public DatabaseLoader(DataBasePopulator dataBasePopulator) {
		this.dataBasePopulator = dataBasePopulator;
	}


	@Override
	public void run(String... args) throws Exception {

		try {
			initDataBase();
//			findPlanesAndMechanics();
//			findLandedFlightsOfaGivenCityAndDate();
//			findCrewDataCitiesAndDatesByCrewCode();
//			findForEachCrewMemberTheTotalNumberOfFlightsAndFlightHours();
		} finally {
			deleteDataBase();
			System.out.println("END");
		}

	}

	private void findPlanesAndMechanics() {
		System.out.println("Query 1:");
		System.out.println("--------------------------------------");
		System.out.println("For each plane:");
		System.out.println("  * Show name and surname of mechanic");
		System.out.println("--------------------------------------\n\n");
	}

	private void findLandedFlightsOfaGivenCityAndDate() {
		System.out.println("Query 2:");
		System.out.println("----------------------------------------");
		System.out.println("Given a city name and date:");
		System.out.println("  * List of landed flights in given city");
		System.out.println("  * Order result by hour");
		System.out.println("----------------------------------------\n\n");
	}

	private void findCrewDataCitiesAndDatesByCrewCode() {
		System.out.println("Query 3:");
		System.out.println("----------------------------------------");
		System.out.println("Given a crew code:");
		System.out.println("  * Show its name and surname");
		System.out.println("  * Show departure (city + date)");
		System.out.println("----------------------------------------\n\n");
	}

	private void findForEachCrewMemberTheTotalNumberOfFlightsAndFlightHours() {
		System.out.println("Query 4:");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("For each crew member:");
		System.out.println("  * Show its name and surname + total number of flights + sum(flight hours)");
		System.out.println("---------------------------------------------------------------------------\n\n");
	}

	private void initDataBase() {
		System.out.println("INIT DATABASE");
		System.out.println("___________________________");
		this.dataBasePopulator.initDataBase();
		System.out.println("---------------------------\n\n");
	}

	private void deleteDataBase(){
		System.out.println("DELETE DATABASE");
		System.out.println("___________________________");
		this.dataBasePopulator.deleteDataBase();
		System.out.println("---------------------------\n\n");
	}
}
