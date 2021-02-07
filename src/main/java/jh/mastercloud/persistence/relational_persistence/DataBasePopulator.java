package jh.mastercloud.persistence.relational_persistence;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

	private static final String PLANE_NUMBER_1 = "AAAAA";
	private static final String PLANE_NUMBER_2 = "BBBBB";
	private static final String PLANE_NUMBER_3 = "CCCCC";

	private static final String MANUFACTURER_BOEING = "BOING";
	private static final String MANUFACTURER_AIRBUS = "AIRBUS";

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


	public void initDataBase() {
		 createPlanes();
	}

	public void deleteDataBase(){
		this.planeRepository.deleteAll();
		this.reviewRepository.deleteAll();
		this.crewRepository.deleteAll();
		this.mechanicRepository.deleteAll();
		this.airportRepository.deleteAll();
		this.flightRepository.deleteAll();
	}

	private void createPlanes(){

		Plane.builder()
		.plateNumber(PLANE_NUMBER_1)
		.manufacturer(BO)
		.model()
		.flightHours()
		.build();

		Plane.builder()
				.plateNumber(PLANE_NUMBER_2)
				.manufacturer()
				.model()
				.flightHours()
				.build();

		Plane.builder()
				.plateNumber(PLANE_NUMBER_3)
				.manufacturer()
				.model()
				.flightHours()
				.build();
		//		this.planeList = Arrays.asList(createPlane(BOEING_747, BOEING, PLATE_NUMBER_XX01, BigDecimal.valueOf(101.5)),
//				createPlane(AIRBUS_25, AIRBUS, PLATE_NUMBER_AA00, BigDecimal.valueOf(1000.5))	);
	}
}
