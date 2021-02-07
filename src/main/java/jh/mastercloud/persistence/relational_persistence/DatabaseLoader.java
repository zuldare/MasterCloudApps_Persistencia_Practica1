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
//			deleteDataBase();
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


//
//	private void generateMechanicsInformation() {
//		System.out.println("-------- PLANE CREATION --------");
//
//		Training trainingCockpit = new Training();
//		trainingCockpit.setTrainingDescription(AIRPLANE_COCKPIT_REPARATION_COURSE);
//
//		Training trainingWheel = new Training();
//		trainingWheel.setTrainingDescription(PLANE_WHEELS_REPARATION_COURSE);
//
//		mechanicRepository.saveAll(
//				Arrays.asList(
//						createMechanic("Manolo", "Gonzales Perez", AIR_EUROPA_COMPANY_NAME, MECHANIC_01_WORKER_CODE, 2000, trainingCockpit),
//						createMechanic("Maria Jesus", "Garcia Garcia", AIR_EUROPA_COMPANY_NAME, MECHANIC_BOSS_AREA_01_WORKER_CODE, 2006, trainingWheel)
//				)
//		);
//
//	}
//
//	private Mechanic createMechanic(String name, String surname, String companyName, String workerCode, Integer incorporationYear, Training training){
//		Mechanic mechanic = new Mechanic();
//		mechanic.setName(name);
//		mechanic.setSurname(surname);
//		mechanic.setCompanyName(companyName);
//		mechanic.setWorkerCode(workerCode);
//		mechanic.setIncorporationYear(incorporationYear);
//		mechanic.setTraining(training);
//
//		return mechanic;
//	}
//
//	private void generateCrewInformation(){
//		System.out.println("-------- PLANE CREATION --------");
//
//		JobPosition jobPositionCaptain = new JobPosition();
//		jobPositionCaptain.setJobDescription(CAPTAIN);
//
//		JobPosition jobPositionCopilot = new JobPosition();
//		jobPositionCopilot.setJobDescription(COPILOT);
//
//		JobPosition jobPositionHostess = new JobPosition();
//		jobPositionHostess.setJobDescription(HOSTESS);
//
//		crewRepository.saveAll(
//				Arrays.asList(
//					createCrewMember("Santiago", "Paradela", AIR_EUROPA_COMPANY_NAME, CAPTAIN_01_WORKERCODE, jobPositionCaptain),
//					createCrewMember("John", "Doe", BRITISH_AIRWAYS_COMPANY_NAME, COP_03_WORKER_CODE, jobPositionCopilot),
//					createCrewMember("Ana", "Perez", BRITISH_AIRWAYS_COMPANY_NAME, HOSTESS_01_WORKER_CODE, jobPositionHostess)
//				)
//		);
//	}
//
//	private Crew createCrewMember(String name, String surname, String companyName, String workerCode, JobPosition jobPosition) {
//		Crew crew = new Crew();
//		crew.setName(name);
//		crew.setSurname(surname);
//		crew.setCompanyName(companyName);
//		crew.setWorkerCode(workerCode);
//		crew.setJobPosition(jobPosition);
//
//		return crew;
//	}
//
//	private void generateReviewsInformation(){
//		System.out.println("-------- PLANE CREATION --------");
//
//		ReviewType sinisterReviewType = new ReviewType();
//		sinisterReviewType.setDescription(SINISTER);
//
//		ReviewType setUpReviewType = new ReviewType();
//		setUpReviewType.setDescription(FIRST_SETUP);
//
//		reviewRepository.saveAll(
//			Arrays.asList(
//					createReview(sinisterReviewType, PLANE_CRASHED_WHILE_TAKE_OFF, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1,31), BigDecimal.valueOf(154.5)),
//					createReview(setUpReviewType, FIRST_SETUP, LocalDate.of(2019, 10, 10), LocalDate.of(2019, 12,31), BigDecimal.valueOf(1540.0))
//			)
//		);
//
//	}
//
//	private Review createReview(ReviewType reviewType, String description, LocalDate beginDate, LocalDate endDate, BigDecimal workedHours){
//		Review review = new Review();
//		review.setReviewType(reviewType);
//		review.setReviewDescription(description);
//		review.setBeginDate(beginDate);
//		review.setEndDate(endDate);
//		review.setWorkedHours(workedHours);
//		return review;
//	}
//
//	private void generatePlanesInformation(){
//		System.out.println("-------- PLANE CREATION --------");
//
//		this.planeList = Arrays.asList(createPlane(BOEING_747, BOEING, PLATE_NUMBER_XX01, BigDecimal.valueOf(101.5)),
//				createPlane(AIRBUS_25, AIRBUS, PLATE_NUMBER_AA00, BigDecimal.valueOf(1000.5))	);
//
//		planeRepository.saveAll(this.planeList);
//	}
//
//	private Plane createPlane(String model, String manufacturer, String plateNumber, BigDecimal flightHours){
//		Plane plane = new Plane();
//		plane.setModel(model);
//		plane.setManufacturer(manufacturer);
//		plane.setPlateNumber(plateNumber);
//		plane.setFlightHours(flightHours);
//
//		return plane;
//	}
//
//	private void generateAirportsInformation(){
//		System.out.println("-------- AIRPLANE CREATION --------");
//		airportRepository.saveAll(
//			Arrays.asList(
//					createAirport(BARAJAS, MAD_IATA_CODE, MADRID, SPAIN),
//					createAirport(HEATHROW, HEATHROW_IATA_CODE, LONDON, UK)
//			)
//		);
//	}
//
//	private Airport createAirport(String name, String iataCode, String city, String country){
//		Airport airport = new Airport();
//		airport.setName(name);
//		airport.setIataCode(iataCode);
//		airport.setCity(city);
//		airport.setCountry(country);
//
//		return airport;
//	}
}
