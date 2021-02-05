package jh.mastercloud.persistence.relational_persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import jh.mastercloud.persistence.relational_persistence.entities.Airport;
import jh.mastercloud.persistence.relational_persistence.entities.Plane;
import jh.mastercloud.persistence.relational_persistence.entities.Review;
import jh.mastercloud.persistence.relational_persistence.entities.ReviewType;
import jh.mastercloud.persistence.relational_persistence.repositories.AirportRepository;
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

	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==================================");
		System.out.println("Testing application DatabaseLoader");
		System.out.println("==================================");

		generatePlaneInformation();
		generateAirportInformation();
		generateReviewInformation();

		System.out.println("====> AIRPLANES");
		planeRepository.findAll().stream().forEach(System.out::println);

		System.out.println("====> AIRPORTS");
		airportRepository.findAll().stream().forEach(System.out::println);

		System.out.println("====> REVIEWS");
		reviewRepository.findAll().stream().forEach(System.out::println);
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
