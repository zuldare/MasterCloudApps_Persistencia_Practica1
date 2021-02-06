package jh.mastercloud.persistence.relational_persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import jh.mastercloud.persistence.relational_persistence.entities.Airport;
import jh.mastercloud.persistence.relational_persistence.entities.Crew;
import jh.mastercloud.persistence.relational_persistence.entities.JobPosition;
import jh.mastercloud.persistence.relational_persistence.entities.Plane;
import jh.mastercloud.persistence.relational_persistence.entities.Review;
import jh.mastercloud.persistence.relational_persistence.entities.ReviewType;
import jh.mastercloud.persistence.relational_persistence.repositories.AirportRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.CrewRepository;
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
	private static final String AIR_EUROPA_COMPANY_NAME = "AIR-EUROPA";
	private static final String CAPTAIN = "CAPTAIN";
	private static final String COPILOT = "COPILOT";
	private static final String BRITISH_AIRWAYS = "BRITISH AIRWAYS";
	private static final String COP_03_WORKER_CODE = "COP-03";

	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private CrewRepository crewRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==================================");
		System.out.println("Testing application DatabaseLoader");
		System.out.println("==================================");

		generatePlaneInformation();
		generateAirportInformation();
		generateReviewInformation();
		generateCrewInformation();

 		// crew
		// flight
		// jobposition
		// mechanic

		System.out.println("====> AIRPLANES");
		planeRepository.findAll().stream().forEach(System.out::println);

		System.out.println("====> AIRPORTS");
		airportRepository.findAll().stream().forEach(System.out::println);

		System.out.println("====> REVIEWS");
		reviewRepository.findAll().stream().forEach(System.out::println);

		System.out.println("====> CREW");
		crewRepository.findAll().stream().forEach(System.out::println);
	}

	private void generateCrewInformation(){
		System.out.println("-------- PLANE CREATION --------");

		JobPosition jobPosition = new JobPosition();
		jobPosition.setJobDescription(CAPTAIN);

		JobPosition jobPosition1 = new JobPosition();
		jobPosition1.setJobDescription(COPILOT);

		crewRepository.saveAll(
				Arrays.asList(
					createCrewMember("Santiago", "Paradela", AIR_EUROPA_COMPANY_NAME, CAPTAIN_01_WORKERCODE, jobPosition),
					createCrewMember("John", "Doe", BRITISH_AIRWAYS, COP_03_WORKER_CODE, jobPosition1)
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

	private void generateReviewInformation(){
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

	private void generatePlaneInformation(){
		System.out.println("-------- PLANE CREATION --------");
		planeRepository.saveAll(
				Arrays.asList(
						createPlane(BOEING_747, BOEING, PLATE_NUMBER_XX01, BigDecimal.valueOf(101.5)),
						createPlane(AIRBUS_25, AIRBUS, PLATE_NUMBER_AA00, BigDecimal.valueOf(1000.5))
				)
		);
	}

	private Plane createPlane(String model, String manufacturer, String plateNumber, BigDecimal flightHours){
		Plane plane = new Plane();
		plane.setModel(model);
		plane.setManufacturer(manufacturer);
		plane.setPlateNumber(plateNumber);
		plane.setFlightHours(flightHours);

		return plane;
	}

	private void generateAirportInformation(){
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
