package jh.mastercloud.persistence.relational_persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.Airport;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.Crew;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.Flight;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.FlightCrew;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.Mechanic;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.Plane;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.Review;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.ReviewType;
import jh.mastercloud.persistence.relational_persistence.entities.mysql.Training;
import jh.mastercloud.persistence.relational_persistence.repositories.AirportRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.CrewRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.FlightCrewRepository;
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
	private static final String WORKER_CODE_CAP_2 = "CAP-0002";
	private static final String WORKER_CODE_LTD_1 = "LTD-0001";
	private static final String WORKER_CODE_LTD_2 = "LTD-0002";
	private static final String WORKER_CODE_HOS_1 = "HOS-3421";
	private static final String WORKER_CODE_HOS_2 = "HOS-9999";

	private static final String JOB_DESC_CAPTAIN = "Captain";
	private static final String JOB_DESC_COPILOT = "Copilot";
	private static final String JOB_DESC_HOSTESS = "Hostess";

	private static final String COMPANY_NAME_BRITISH = "British Airways";
	private static final String COMPANY_NAME_AIREUROPA = "Air Europa";

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

	private static final String TRAINING_GRADE = "Grado";
	private static final String TRAINING_FP = "FP";
	private static final String REVIEW_COCKPIT = "COCKPIT REVIEW";
	private static final String REVIEW_COCKPIT_WIRE_INSTALLATION = "Review cockpit wire installation";
	private static final String REVIEW_WHEELS = "WHEELS REVIEW";
	private static final String REVIEW_WHEELS_ANUAL_CHECK = "Check wheel integrity";

  private static final String REVIEW_GENERAL_CHECK = "General maintenance";
  private static final String REVIEW_GENERAL = "GENERAL REVIEW";

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

	@Autowired
	private FlightCrewRepository flightCrewRepository;

  private Map<String, Plane> planes = new HashMap<>();
  private Map<String, Airport> airports = new HashMap<>();
  private Map<String, Crew> crewMembers = new HashMap<>();
  private Map<String, Flight> flights = new HashMap<>();
  private Map<String, Mechanic> mechanics = new HashMap<>();

  private LocalDateTime dateTime_2020_01_31_08_30 = LocalDateTime.of(2020,1,31,8,30,0);
  private LocalDateTime dateTime_2020_01_01_13_45 = LocalDateTime.of(2020, 1, 1,13,45,0);
  private LocalDate reviewCockpitDate = LocalDate.of(2019, 12, 12);
  private LocalDate reviewWheelDate = LocalDate.of(2019, 11, 11);
  private LocalDate	reviewGeneralDate = LocalDate.of(2019, 12, 04);

	public void initDataBase() {
		 createPlanes();
		 createAirports();
		 createCrewMembers();
		 createMechanics();
		 createPlaneReviews();
		 createFlights();

	}

	public void deleteDataBase(){
		this.flightCrewRepository.deleteAll();
		this.reviewRepository.deleteAll();
		this.crewRepository.deleteAll();
		this.mechanicRepository.deleteAll();
		this.flightRepository.deleteAll();
		this.airportRepository.deleteAll();
		this.planeRepository.deleteAll();
		this.initData();
	}

	private void initData(){
		this.planes = new HashMap<>();
		this.airports = new HashMap<>();
		this.crewMembers = new HashMap<>();
		this.flights = new HashMap<>();
		this.mechanics = new HashMap<>();
	}

	private void createPlaneReviews(){
		Review reviewCockpitMadrid = Review.builder().beginDate(reviewCockpitDate).endDate(reviewCockpitDate).workedHours(BigDecimal.TEN)
				.reviewType(new ReviewType(REVIEW_COCKPIT)).reviewDescription(REVIEW_COCKPIT_WIRE_INSTALLATION)
				.plane(this.planes.get(PLANE_NUMBER_1)).mechanic(this.mechanics.get(WORKER_CODE_MEC_1))
				.airport(this.airports.get(CITY_MADRID)).build();

		Review reviewWheelsLondon = Review.builder().beginDate(reviewWheelDate).endDate(reviewWheelDate).workedHours(BigDecimal.ONE)
				.reviewType(new ReviewType(REVIEW_WHEELS)).reviewDescription(REVIEW_WHEELS_ANUAL_CHECK)
				.plane(this.planes.get(PLANE_NUMBER_1)).mechanic(this.mechanics.get(WORKER_CODE_MEC_2))
				.airport(this.airports.get(CITY_LONDON)).build();


		Review reviewGeneralLondon = Review.builder().beginDate(reviewGeneralDate).endDate(reviewGeneralDate).workedHours(BigDecimal.valueOf(2.5))
				.reviewType(new ReviewType(REVIEW_GENERAL)).reviewDescription(REVIEW_GENERAL_CHECK)
				.plane(this.planes.get(PLANE_NUMBER_2)).mechanic(this.mechanics.get(WORKER_CODE_MEC_2))
				.airport(this.airports.get(CITY_LONDON)).build();

		System.out.println("---> INSERT REVIEWS <---");
		this.reviewRepository.saveAll(Arrays.asList(reviewCockpitMadrid, reviewWheelsLondon, reviewGeneralLondon));
		System.out.println("-----------------------------\n\n");
	}

	private void createMechanics(){
		Mechanic mechanic1 = new Mechanic(WORKER_CODE_MEC_1, "Pepe", "Gotera", COMPANY_NAME_AIREUROPA, new Training(TRAINING_GRADE),2014);
		Mechanic mechanic2 = new Mechanic(WORKER_CODE_MEC_2, "Otilio", "Otilio", COMPANY_NAME_BRITISH, new Training(TRAINING_FP), 2016);
		this.mechanics.put(WORKER_CODE_MEC_1, mechanic1);
		this.mechanics.put(WORKER_CODE_MEC_2, mechanic2);

		System.out.println("---> INSERT MECHANICS <---");
		this.mechanicRepository.saveAll(this.mechanics.values());
		System.out.println("-----------------------------\n\n");
	}

	private void createPlanes(){
		this.planes.put(PLANE_NUMBER_1, Plane.builder().plateNumber(PLANE_NUMBER_1).manufacturer(MANUFACTURER_AIRBUS).model("A380").flightHours(BigDecimal.valueOf(1755.0)).build());
		this.planes.put(PLANE_NUMBER_2, Plane.builder().plateNumber(PLANE_NUMBER_2).manufacturer(MANUFACTURER_AIRBUS).model("A380").flightHours(BigDecimal.valueOf(685.5)).build());
		this.planes.put(PLANE_NUMBER_3, Plane.builder().plateNumber(PLANE_NUMBER_3).manufacturer(MANUFACTURER_BOEING).model("747").flightHours(BigDecimal.valueOf(150.0)).build());

		System.out.println("---> INSERT PLANES <---");
		planeRepository.saveAll(this.planes.values());
		System.out.println("-----------------------------\n\n");
	}

	private void createAirports(){
		this.airports.put(CITY_MADRID, Airport.builder().city(CITY_MADRID).country("ES").iataCode("MAD").name(AIRPORT_MADRID).build());
		this.airports.put(CITY_LONDON, Airport.builder().city(CITY_LONDON).country("UK").iataCode("LHR").name(AIRPORT_LONDON).build());
		this.airports.put(CITY_PARIS, Airport.builder().city(CITY_PARIS).country("FR").iataCode("ORY").name(AIRPORT_PARIS).build());

		System.out.println("---> INSERT AIRPORTS <---");
		airportRepository.saveAll(this.airports.values());
		System.out.println("-----------------------------\n\n");
	}

	private void createCrewMembers(){
		this.crewMembers.put(WORKER_CODE_CAP_1, Crew.builder().workerCode(WORKER_CODE_CAP_1).name("Santiago").surname("Paradelas")
				.companyName(COMPANY_NAME_AIREUROPA).jobPosition(JOB_DESC_CAPTAIN).build());
		this.crewMembers.put(WORKER_CODE_LTD_1, Crew.builder().workerCode(WORKER_CODE_LTD_1).name("John").surname("Doe")
				.companyName(COMPANY_NAME_AIREUROPA).jobPosition(JOB_DESC_COPILOT).build());
		this.crewMembers.put(WORKER_CODE_HOS_1, Crew.builder().workerCode(WORKER_CODE_HOS_1).name("Ana").surname("Garcia")
				.companyName(COMPANY_NAME_AIREUROPA).jobPosition(JOB_DESC_HOSTESS).build());

		this.crewMembers.put(WORKER_CODE_CAP_2, Crew.builder().workerCode(WORKER_CODE_CAP_2).name("Pedro").surname("Mancias")
				.companyName(COMPANY_NAME_BRITISH).jobPosition(JOB_DESC_CAPTAIN).build());
		this.crewMembers.put(WORKER_CODE_LTD_2, Crew.builder().workerCode(WORKER_CODE_LTD_1).name("Juan").surname("Pil")
				.companyName(COMPANY_NAME_BRITISH).jobPosition(JOB_DESC_COPILOT).build());
		this.crewMembers.put(WORKER_CODE_HOS_2, Crew.builder().workerCode(WORKER_CODE_HOS_1).name("Maria").surname("Fernandez")
				.companyName(COMPANY_NAME_BRITISH).jobPosition(JOB_DESC_HOSTESS).build());

		System.out.println("---> INSERT CREW MEMBERS <---");
		crewRepository.saveAll(this.crewMembers.values());
		System.out.println("-----------------------------\n\n");
	}

	private void createFlights(){
		// MAD --> LONDON
		Flight flightMadridLondon = Flight.builder().flightCode(FLIGHT_CODE_MAD_LONDON)
				.companyName(COMPANY_NAME_AIREUROPA)
				.flightDepartureDateTime(dateTime_2020_01_31_08_30)
				.flightDuration(BigDecimal.valueOf(2.0))
				.plane(this.planes.get(PLANE_NUMBER_1))
				.departureAirport(this.airports.get(CITY_MADRID))
				.destinationAirport(this.airports.get(CITY_LONDON))
				.build();
		this.flights.put(FLIGHT_CODE_MAD_LONDON, flightMadridLondon);

		// MAD --> PARIS
		Flight flightMadridParis = Flight.builder().flightCode(FLIGHT_CODE_MAD_PARIS)
				.companyName(COMPANY_NAME_AIREUROPA)
				.flightDepartureDateTime(dateTime_2020_01_01_13_45)
				.flightDuration(BigDecimal.valueOf(1.5))
				.plane(this.planes.get(PLANE_NUMBER_1))
				.departureAirport(this.airports.get(CITY_MADRID))
				.destinationAirport(this.airports.get(CITY_PARIS))
				.build();
		this.flights.put(FLIGHT_CODE_MAD_PARIS, flightMadridParis);

		// LONDON --> PARIS
		Flight flightLondonParis = Flight.builder().flightCode(FLIGHT_CODE_LONDON_PARIS)
				.companyName(COMPANY_NAME_BRITISH)
				.flightDepartureDateTime(dateTime_2020_01_01_13_45)
				.flightDuration(BigDecimal.valueOf(2.5))
				.plane(this.planes.get(PLANE_NUMBER_3))
				.departureAirport(this.airports.get(CITY_LONDON))
				.destinationAirport(this.airports.get(CITY_PARIS))
				.build();
		this.flights.put(FLIGHT_CODE_LONDON_PARIS, flightLondonParis);

		System.out.println("---> INSERT FLIGHTS FIRST TIME WITHOUT CREW <---");
		flightRepository.saveAll(this.flights.values());
		System.out.println("-----------------------------");

		System.out.println("---> ASSIGN CREW TO FLIGHT <---");
		flightLondonParis.setCrewList(assignCrewToFlight(flightLondonParis, new ArrayList(Arrays.asList(this.crewMembers.get(WORKER_CODE_CAP_2), this.crewMembers.get(WORKER_CODE_LTD_2), this.crewMembers.get(WORKER_CODE_HOS_2)))));
		flightMadridLondon.setCrewList(assignCrewToFlight(flightMadridLondon, new ArrayList(Arrays.asList(this.crewMembers.get(WORKER_CODE_CAP_1), this.crewMembers.get(WORKER_CODE_LTD_1), this.crewMembers.get(WORKER_CODE_HOS_1)))));
		flightMadridParis.setCrewList(assignCrewToFlight(flightMadridParis, new ArrayList(Arrays.asList(this.crewMembers.get(WORKER_CODE_CAP_1), this.crewMembers.get(WORKER_CODE_LTD_1), this.crewMembers.get(WORKER_CODE_HOS_1))) ));
		System.out.println("-----------------------------");

		System.out.println("---> INSERT FLIGHTS SECOND TIME WITH CREW <---");
		flightRepository.saveAll(Arrays.asList(flightMadridLondon, flightLondonParis, flightMadridParis));
		System.out.println("-----------------------------");
	}

	private List<FlightCrew> assignCrewToFlight(Flight flight, List<Crew> crewList){
		List<FlightCrew> flightCrewList = new ArrayList<>();

		for(int i=0; i< crewList.size(); i++){
			flightCrewList.add(new FlightCrew(flight, crewList.get(i)));
		}
		this.flightCrewRepository.saveAll(flightCrewList);
		return flightCrewList;
	}

}
