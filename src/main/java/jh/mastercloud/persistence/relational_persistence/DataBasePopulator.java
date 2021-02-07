package jh.mastercloud.persistence.relational_persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import jh.mastercloud.persistence.relational_persistence.entities.Airport;
import jh.mastercloud.persistence.relational_persistence.entities.Crew;
import jh.mastercloud.persistence.relational_persistence.entities.Flight;
import jh.mastercloud.persistence.relational_persistence.entities.FlightCrew;
import jh.mastercloud.persistence.relational_persistence.entities.Plane;
import jh.mastercloud.persistence.relational_persistence.repositories.AirportRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.CrewRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.FlightRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.MechanicRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.PlaneRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBasePopulator {

	private static final String WORKER_CODE_MEC_1 = "MEC-0001";
	private static final String WORKER_CODE_MEC_2 = "MEC-1002";
	private static final String WORKER_CODE_CAP_1 = "CAP-0001";
	private static final String WORKER_CODE_LTD_1 = "LTD-0001";
	private static final String WORKER_CODE_HOS_1 = "HOS-3421";

	private static final String JOB_DESC_CAPTAIN = "Captain";
	private static final String JOB_DESC_COPILOT = "Copilot";
	private static final String JOB_DESC_MECHANIC = "Mechanic";
	private static final String JOB_DESC_HOSTESS = "Hostess";

	private static final String COMPANY_NAME_BRITISH = "British Airways";
	private static final String COMPANY_NAME_AIREUROPA = "Air Europa";
	private static final String COMPANY_NAME_HOSTESS = "Hostess S.A.";

	private static final String PLANE_NUMBER_1 = "AAAAA";
	private static final String PLANE_NUMBER_2 = "BBBBB";
	private static final String PLANE_NUMBER_3 = "CCCCC";

	private static final String MANUFACTURER_BOEING = "BOING";
	private static final String MANUFACTURER_AIRBUS = "AIRBUS";

	private static final String CITY_MADRID = "MADRID";
	private static final String CITY_LONDON = "LONDON";
	private static final String CITY_PARIS = "PARIS";

	private static final String AIRPORT_MADRID = "Adolfo Suárez Madrid-Barajas";
	private static final String AIRPORT_LONDON = "Heathrow";
	private static final String AIRPORT_PARIS = "Paris-Orly";

	private static final String FLIGHT_CODE_MAD_LONDON = "AE111";
	private static final String FLIGHT_CODE_MAD_PARIS = "AE999";
	private static final String FLIGHT_CODE_LONDON_PARIS = "BA555";

	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private CrewRepository crewRepository;

	@Autowired
	private MechanicRepository mechanicRepository;

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private FlightRepository flightRepository;

  private Map<String, Plane> planes = new HashMap<>();
  private Map<String, Airport> airports = new HashMap<>();
  private Map<String, Crew> crewMembers = new HashMap<>();
  private Map<String, Flight> flights = new HashMap<>();

  private LocalDateTime dateTime_2020_01_31_08_30 = LocalDateTime.of(2020,1,31,8,30,0);
  private LocalDateTime dateTime_2020_02_15_10_50 = LocalDateTime.of(2020,2,15, 10,50,0);
  private LocalDateTime dateTime_2020_01_01_13_45 = LocalDateTime.of(2020, 1, 1,13,45,0);

	public void initDataBase() {
		 createPlanes();
		 createAirports();
		 createCrewMembers();
		 createFlights();
//		 assingCrewToFlights();
//		 createMechanics();
//		 createPlaneReviews();
	}

	public void deleteDataBase(){
		this.planeRepository.deleteAll();
		this.reviewRepository.deleteAll();
		this.crewRepository.deleteAll();
		this.mechanicRepository.deleteAll();
		this.airportRepository.deleteAll();
		this.flightRepository.deleteAll();
		this.initData();
	}

	private void initData(){
		this.airports = new HashMap<>();
		this.planes = new HashMap<>();
	}

	private void createPlanes(){
		this.planes.put(PLANE_NUMBER_1, Plane.builder().plateNumber(PLANE_NUMBER_1).manufacturer(MANUFACTURER_AIRBUS).model("A380").flightHours(BigDecimal.valueOf(1755.0)).build());
		this.planes.put(PLANE_NUMBER_2, Plane.builder().plateNumber(PLANE_NUMBER_2).manufacturer(MANUFACTURER_AIRBUS).model("A380").flightHours(BigDecimal.valueOf(685.5)).build());
		this.planes.put(PLANE_NUMBER_3, Plane.builder().plateNumber(PLANE_NUMBER_3).manufacturer(MANUFACTURER_BOEING).model("747").flightHours(BigDecimal.valueOf(150.0)).build());

		planeRepository.saveAll(this.planes.values());
	}

	private void createAirports(){
		this.airports.put(CITY_MADRID, Airport.builder().city(CITY_MADRID).country("ES").iataCode("MAD").name(AIRPORT_MADRID).build());
		this.airports.put(CITY_LONDON, Airport.builder().city(CITY_LONDON).country("UK").iataCode("LHR").name(AIRPORT_LONDON).build());
		this.airports.put(CITY_PARIS, Airport.builder().city(CITY_PARIS).country("FR").iataCode("ORY").name(AIRPORT_PARIS).build());

		airportRepository.saveAll(this.airports.values());
	}

	private void createCrewMembers(){


		this.crewMembers.put(WORKER_CODE_CAP_1, Crew.builder().workerCode(WORKER_CODE_CAP_1).name("Santiago").surname("Paradelas")
				.companyName(COMPANY_NAME_AIREUROPA).jobPosition(JOB_DESC_CAPTAIN).build());
		this.crewMembers.put(WORKER_CODE_LTD_1, Crew.builder().workerCode(WORKER_CODE_LTD_1).name("John").surname("Doe")
				.companyName(COMPANY_NAME_AIREUROPA).jobPosition(JOB_DESC_COPILOT).build());
		this.crewMembers.put(WORKER_CODE_HOS_1, Crew.builder().workerCode(WORKER_CODE_HOS_1).name("Ana").surname("Garcia")
				.companyName(COMPANY_NAME_HOSTESS).jobPosition(JOB_DESC_HOSTESS).build());

		crewRepository.saveAll(this.crewMembers.values());
	}

	private void createFlights(){

		this.flights.put(FLIGHT_CODE_MAD_LONDON, Flight.builder().flightCode(FLIGHT_CODE_MAD_LONDON)
				.companyName(COMPANY_NAME_AIREUROPA)
				.flightDepartureDateTime(dateTime_2020_01_31_08_30)
				.flightDuration(BigDecimal.valueOf(2.0))
				.plane(this.planes.get(PLANE_NUMBER_1))
				.departureAirport(this.airports.get(CITY_MADRID))
				.destinationAirport(this.airports.get(CITY_LONDON))
				.build());

		this.flights.put(FLIGHT_CODE_MAD_PARIS, Flight.builder().flightCode(FLIGHT_CODE_MAD_PARIS)
				.companyName(COMPANY_NAME_AIREUROPA)
				.flightDepartureDateTime(dateTime_2020_02_15_10_50)
				.flightDuration(BigDecimal.valueOf(1.5))
				.plane(this.planes.get(PLANE_NUMBER_1))
				.departureAirport(this.airports.get(CITY_MADRID))
				.destinationAirport(this.airports.get(CITY_PARIS))
				.build());

		this.flights.put(FLIGHT_CODE_LONDON_PARIS, Flight.builder().flightCode(FLIGHT_CODE_LONDON_PARIS)
				.companyName(COMPANY_NAME_BRITISH)
				.flightDepartureDateTime(dateTime_2020_01_01_13_45)
				.flightDuration(BigDecimal.valueOf(2.5))
				.plane(this.planes.get(PLANE_NUMBER_3))
				.departureAirport(this.airports.get(CITY_LONDON))
				.destinationAirport(this.airports.get(CITY_PARIS))
				.build());
//		private List<FlightCrew> crewList;

		flightRepository.saveAll(this.flights.values());

	}
}
