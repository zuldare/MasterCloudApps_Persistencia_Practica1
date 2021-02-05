package jh.mastercloud.persistence.relational_persistence;

import java.math.BigDecimal;
import java.util.Arrays;
import jh.mastercloud.persistence.relational_persistence.entities.Airport;
import jh.mastercloud.persistence.relational_persistence.entities.Plane;
import jh.mastercloud.persistence.relational_persistence.repositories.AirportRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.PlaneRepository;
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

	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private AirportRepository airportRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==================================");
		System.out.println("Testing application DatabaseLoader");
		System.out.println("==================================");

		generatePlaneInformation();
		generateAirportInformation();

		System.out.println("====> AIRPLANES");
		planeRepository.findAll().stream().forEach(System.out::println);

		System.out.println("====> AIRPORTS");
		airportRepository.findAll().stream().forEach(System.out::println);
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
