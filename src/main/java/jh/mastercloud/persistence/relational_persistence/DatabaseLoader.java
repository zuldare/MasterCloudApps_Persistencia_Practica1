package jh.mastercloud.persistence.relational_persistence;

import java.util.List;
import jh.mastercloud.persistence.relational_persistence.dtos.mysql.CrewFromFlightDto;
import jh.mastercloud.persistence.relational_persistence.repositories.AirportRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.CrewRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.FlightCrewRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.FlightRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.MechanicRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.PlaneRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	private final DataBasePopulator dataBasePopulator;
	private final DataLogger dataLogger;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private CrewRepository crewRepository;

	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private MechanicRepository mechanicRepository;

	@Autowired
	private FlightCrewRepository flightCrewRepository;

	public DatabaseLoader(DataBasePopulator dataBasePopulator, DataLogger dataLogger) {
		this.dataBasePopulator = dataBasePopulator;
		this.dataLogger = dataLogger;
	}

	@Override
	public void run(String... args) throws Exception {

		// PRACTICE 1
		mySQLPart();

		// PRACTICE 2 PART 2
		printHybridDataBase();

		// PRACTICE 2 PART 3
		printMongoDBInformation();

	}

	/* ************************
	 * PRACTICE 2.   PART 2   *
	 * ************************
	 */
	private void printHybridDataBase(){

	}


	/* ************************
	 * PRACTICE 2.   PART 3   *
	 * ************************
	 */
	private void printMongoDBInformation(){
		System.out.println("===============================>");
		System.out.println("====> AGGREGATION FRAMEWORK ");
		System.out.println("===============================>\n");
		dataLogger.printAllProvinces();
		dataLogger.printCAProvincesInfo();
	}


	/* ********************************
	   *   MYSQL PART.  PRACTICE 1    *
	   ********************************
	 */

	private void mySQLPart(){
		printDatabase();
		printQueries();
	}

	private void printDatabase(){
		System.out.println("===============================>");
		System.out.println("====> PRINT DATABASE INFO ");
		System.out.println("===============================>\n");
		printAirportDatabaseInfo();
		printCrewDatabaseInfo();
	  printFlightDatabaseInfo();
		printMechanicDatabaseInfo();
		printPlaneDatabaseInfo();
		printReviewDatabaseInfo();
	}

	private void printAirportDatabaseInfo(){
		System.out.println("====> AIRPORT");
		System.out.println("--------------------------------------\n");
		airportRepository.findAll()
				.stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}

	private void printCrewDatabaseInfo(){
		System.out.println("====> CREW");
		System.out.println("--------------------------------------\n");
		crewRepository.findAll()
				.stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}

	private void printFlightDatabaseInfo(){
		System.out.println("====> FLIGHT");
		System.out.println("--------------------------------------\n");
		flightRepository.findAll()
				.stream().forEach(element -> {
				 List<CrewFromFlightDto> crew = flightCrewRepository.findCrewFromFlight(element.getId());
			   System.out.println(element + " (Flight Crew: " + crew + ")");
		});
		System.out.println("--------------------------------------\n\n");
	}

	private void printMechanicDatabaseInfo(){
		System.out.println("====> MECHANIC");
		System.out.println("--------------------------------------\n");
		mechanicRepository.findAll()
				.stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}

	private void printPlaneDatabaseInfo(){
		System.out.println("====> PLANE");
		System.out.println("--------------------------------------\n");
		planeRepository.findAll()
				.stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}

	private void printReviewDatabaseInfo(){
		System.out.println("====> REVIEW");
		System.out.println("--------------------------------------\n");
		reviewRepository.findAll()
				.stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}

	private void printQueries(){
		findPlanesAndMechanics();
		findLandedFlightsOfaGivenCityAndDate();
		findCrewDataCitiesAndDatesByCrewCode();
		findForEachCrewMemberTheTotalNumberOfFlightsAndFlightHours();
	}

	private void findPlanesAndMechanics() {
		System.out.println("Query 1:");
		System.out.println("--------------------------------------");
		System.out.println("For each plane:");
		System.out.println("  * Show name and surname of mechanic \n");

		reviewRepository.findMechanicNameSurnameOfReviewedPlanesWithJoins()
				.stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}

	private void findLandedFlightsOfaGivenCityAndDate() {
		System.out.println("Query 2:");
		System.out.println("----------------------------------------");
		System.out.println("Given a city name and date:");
		System.out.println("  * List of landed flights in given city");
		System.out.println("  * Order result by hour\n");

		airportRepository
				.findFlightsGivenCityAndDateOrderedByDepartureDateTime("PARIS".toLowerCase(), "2020-01-01")
				.stream().forEach(System.out::println);

		System.out.println("----------------------------------------\n\n");
	}

	private void findCrewDataCitiesAndDatesByCrewCode() {
		System.out.println("Query 3:");
		System.out.println("----------------------------------------");
		System.out.println("Given a crew code:");
		System.out.println("  * Show its name and surname");
		System.out.println("  * Show departure (city + date)\n");

		this.crewRepository.findCrewDataDepartureInfoByWorkerCode("CAP-0001")
		.stream().forEach(System.out::println);
		System.out.println("----------------------------------------\n\n");
	}

	private void findForEachCrewMemberTheTotalNumberOfFlightsAndFlightHours() {
		System.out.println("Query 4:");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("For each crew member:");
		System.out.println("  * Show its name and surname + total number of flights + sum(flight hours)\n");

		this.flightCrewRepository.findCrewDataFlightCountFlightDurationSum()
				.stream().forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------------\n\n");
	}

	private void initDataBase() {
		System.out.println("INIT DATABASE");
		System.out.println("___________________________");
		this.dataBasePopulator.initDataBase();
		System.out.println("------- END OF DATABASE INITIALIZATION --------------------\n\n");
	}

	private void deleteDataBase(){
		System.out.println("DELETE DATABASE");
		System.out.println("___________________________");
		this.dataBasePopulator.deleteDataBase();
		System.out.println("---------------------------\n\n");
	}
}
