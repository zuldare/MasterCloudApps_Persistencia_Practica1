package jh.mastercloud.persistence.relational_persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jh.mastercloud.persistence.relational_persistence.entities.Airport;
import jh.mastercloud.persistence.relational_persistence.entities.Crew;
import jh.mastercloud.persistence.relational_persistence.entities.Flight;
import jh.mastercloud.persistence.relational_persistence.entities.JobPosition;
import jh.mastercloud.persistence.relational_persistence.entities.Mechanic;
import jh.mastercloud.persistence.relational_persistence.entities.Plane;
import jh.mastercloud.persistence.relational_persistence.entities.Review;
import jh.mastercloud.persistence.relational_persistence.entities.ReviewType;
import jh.mastercloud.persistence.relational_persistence.entities.Training;
import jh.mastercloud.persistence.relational_persistence.repositories.AirportRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.CrewRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.FlightRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.MechanicRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.PlaneRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	private static final String BOEING_747 = "Boeing 747";
	private static final String PLATE_NUMBER_XX01 = "XX-01";
	private static final String BOEING = "BOEING";
	private static final String AIRBUS_25 = "AIRBUS-25";
	private static final String AIRBUS = "AIRBUS";
	private static final String PLATE_NUMBER_AA00 = "AA-00";
	private static final String BARAJAS = "Barajas";
	private static final String MAD_IATA_CODE = "MAD";
	private static final String MADRID = "MADRID";
	private static final String SPAIN = "SPAIN";
	private static final String HEATHROW = "Heathrow";
	private static final String HEATHROW_IATA_CODE = "LHR";
	private static final String LONDON = "London";
	private static final String UK = "UK";
	private static final String SINISTER = "Sinister";
	private static final String PLANE_CRASHED_WHILE_TAKE_OFF = "Plane crashed while take off";
	private static final String FIRST_SETUP = "First setup";
	private static final String CAPTAIN_01_WORKERCODE = "CAPTAIN-01";
	private static final String COP_03_WORKER_CODE = "COP-03";
	private static final String MECHANIC_01_WORKER_CODE = "MEC-01";
	private static final String HOSTESS_01_WORKER_CODE = "HOS-01";
	private static final String AIR_EUROPA_COMPANY_NAME = "AIR-EUROPA";
	private static final String BRITISH_AIRWAYS_COMPANY_NAME = "BRITISH AIRWAYS";
	private static final String CAPTAIN = "CAPTAIN";
	private static final String COPILOT = "COPILOT";
	private static final String AIRPLANE_COCKPIT_REPARATION_COURSE = "Airplane cockpit reparation course";
	private static final String PLANE_WHEELS_REPARATION_COURSE = "PLANE WHEELS REPARATION COURSE";
	private static final String MECHANIC_BOSS_AREA_01_WORKER_CODE = "MECHANIC-BOSS-AREA-01";
	private static final String HOSTESS = "HOSTESS";

	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private CrewRepository crewRepository;

	@Autowired
	private MechanicRepository mechanicRepository;

	@Autowired
	private FlightRepository flightRepository;

	private List<Plane> planeList;
	private List<Flight> flightList;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==================================");
		System.out.println("Testing application DatabaseLoader");
		System.out.println("==================================");

		generatePlanesInformation();
//		generateAirportsInformation();
//		generateReviewsInformation();
//		generateCrewInformation();
//		generateMechanicsInformation();
		generateFlightsInformation();

		System.out.println("\n\n====> AIRPLANES");
		planeRepository.findAll().stream().forEach(System.out::println);

//		System.out.println("\n\n====> AIRPORTS");
//		airportRepository.findAll().stream().forEach(System.out::println);
//
//		System.out.println("\n\n====> REVIEWS");
//		reviewRepository.findAll().stream().forEach(System.out::println);
//
//		System.out.println("\n\n====> CREW");
//		crewRepository.findAll().stream().forEach(System.out::println);
//
//		System.out.println("\n\n====> MECHANICS");
//		mechanicRepository.findAll().stream().forEach(System.out::println);

		System.out.println("\n\n====> FLIGHTS");
		flightRepository.findAll().stream().forEach(System.out::println);

		System.out.println("\n\n");

	}


	private void generateFlightsInformation(){
		System.out.println("-------- FLIGHT CREATION --------");

		flightList = Arrays.asList(
				Flight.builder().flightCode("BA-0000").companyName(BRITISH_AIRWAYS_COMPANY_NAME)
						.flightDuration(BigDecimal.valueOf(10.5))
						.flightDepartureDateTime(LocalDateTime.of(2020,01,31,10,30,0))
						.plane(planeList.get(0)).build(),

				Flight.builder().flightCode("AE-0034")
						.companyName(AIR_EUROPA_COMPANY_NAME)
						.flightDuration(BigDecimal.valueOf(2.5))
						.flightDepartureDateTime(LocalDateTime.of(2020,02,1,10,30,0))
						.plane(planeList.get(1)).build()
		);
		flightRepository.saveAll(flightList);
	}



	private void generateMechanicsInformation() {
		System.out.println("-------- PLANE CREATION --------");

		Training trainingCockpit = new Training();
		trainingCockpit.setTrainingDescription(AIRPLANE_COCKPIT_REPARATION_COURSE);

		Training trainingWheel = new Training();
		trainingWheel.setTrainingDescription(PLANE_WHEELS_REPARATION_COURSE);

		mechanicRepository.saveAll(
				Arrays.asList(
						createMechanic("Manolo", "Gonzales Perez", AIR_EUROPA_COMPANY_NAME, MECHANIC_01_WORKER_CODE, 2000, trainingCockpit),
						createMechanic("Maria Jesus", "Garcia Garcia", AIR_EUROPA_COMPANY_NAME, MECHANIC_BOSS_AREA_01_WORKER_CODE, 2006, trainingWheel)
				)
		);

	}

	private Mechanic createMechanic(String name, String surname, String companyName, String workerCode, Integer incorporationYear, Training training){
		Mechanic mechanic = new Mechanic();
		mechanic.setName(name);
		mechanic.setSurnames(surname);
		mechanic.setCompanyName(companyName);
		mechanic.setWorkerCode(workerCode);
		mechanic.setIncorporationYear(incorporationYear);
		mechanic.setTraining(training);

		return mechanic;
	}

	private void generateCrewInformation(){
		System.out.println("-------- PLANE CREATION --------");

		JobPosition jobPositionCaptain = new JobPosition();
		jobPositionCaptain.setJobDescription(CAPTAIN);

		JobPosition jobPositionCopilot = new JobPosition();
		jobPositionCopilot.setJobDescription(COPILOT);

		JobPosition jobPositionHostess = new JobPosition();
		jobPositionHostess.setJobDescription(HOSTESS);

		crewRepository.saveAll(
				Arrays.asList(
					createCrewMember("Santiago", "Paradela", AIR_EUROPA_COMPANY_NAME, CAPTAIN_01_WORKERCODE, jobPositionCaptain),
					createCrewMember("John", "Doe", BRITISH_AIRWAYS_COMPANY_NAME, COP_03_WORKER_CODE, jobPositionCopilot),
					createCrewMember("Ana", "Perez", BRITISH_AIRWAYS_COMPANY_NAME, HOSTESS_01_WORKER_CODE, jobPositionHostess)
				)
		);
	}

	private Crew createCrewMember(String name, String surname, String companyName, String workerCode, JobPosition jobPosition) {
		Crew crew = new Crew();
		crew.setName(name);
		crew.setSurnames(surname);
		crew.setCompanyName(companyName);
		crew.setWorkerCode(workerCode);
		crew.setJobPosition(jobPosition);

		return crew;
	}

	private void generateReviewsInformation(){
		System.out.println("-------- PLANE CREATION --------");

		ReviewType sinisterReviewType = new ReviewType();
		sinisterReviewType.setDescription(SINISTER);

		ReviewType setUpReviewType = new ReviewType();
		setUpReviewType.setDescription(FIRST_SETUP);

		reviewRepository.saveAll(
			Arrays.asList(
					createReview(sinisterReviewType, PLANE_CRASHED_WHILE_TAKE_OFF, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1,31), BigDecimal.valueOf(154.5)),
					createReview(setUpReviewType, FIRST_SETUP, LocalDate.of(2019, 10, 10), LocalDate.of(2019, 12,31), BigDecimal.valueOf(1540.0))
			)
		);

	}

	private Review createReview(ReviewType reviewType, String description, LocalDate beginDate, LocalDate endDate, BigDecimal workedHours){
		Review review = new Review();
		review.setReviewType(reviewType);
		review.setReviewDescription(description);
		review.setBeginDate(beginDate);
		review.setEndDate(endDate);
		review.setWorkedHours(workedHours);
		return review;
	}

	private void generatePlanesInformation(){
		System.out.println("-------- PLANE CREATION --------");

		this.planeList = Arrays.asList(createPlane(BOEING_747, BOEING, PLATE_NUMBER_XX01, BigDecimal.valueOf(101.5)),
				createPlane(AIRBUS_25, AIRBUS, PLATE_NUMBER_AA00, BigDecimal.valueOf(1000.5))	);

		planeRepository.saveAll(this.planeList);
	}

	private Plane createPlane(String model, String manufacturer, String plateNumber, BigDecimal flightHours){
		Plane plane = new Plane();
		plane.setModel(model);
		plane.setManufacturer(manufacturer);
		plane.setPlateNumber(plateNumber);
		plane.setFlightHours(flightHours);

		return plane;
	}

	private void generateAirportsInformation(){
		System.out.println("-------- AIRPLANE CREATION --------");
		airportRepository.saveAll(
			Arrays.asList(
					createAirport(BARAJAS, MAD_IATA_CODE, MADRID, SPAIN),
					createAirport(HEATHROW, HEATHROW_IATA_CODE, LONDON, UK)
			)
		);
	}

	private Airport createAirport(String name, String iataCode, String city, String country){
		Airport airport = new Airport();
		airport.setName(name);
		airport.setIataCode(iataCode);
		airport.setCity(city);
		airport.setCountry(country);

		return airport;
	}
}
