package jh.mastercloud.persistence.relational_persistence;

import java.util.List;
import java.util.stream.Collectors;
import jh.mastercloud.persistence.relational_persistence.dtos.mysql.PlaneMechanicNameSurnameDto;
import jh.mastercloud.persistence.relational_persistence.repositories.PlaneRepository;
import jh.mastercloud.persistence.relational_persistence.repositories.ProvinceRepository;
import org.springframework.stereotype.Component;

@Component
public class DataLogger {

	private final ProvinceRepository provinceRepository;
	private final PlaneRepository planeRepository;

	public DataLogger(ProvinceRepository provinceRepository, PlaneRepository planeRepository) {
		this.provinceRepository = provinceRepository;
		this.planeRepository = planeRepository;
	}


	public void printAllProvinces(){
		System.out.println("====> Provinces");
		System.out.println("--------------------------------------\n");
		provinceRepository.findAll().stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}

	public void printCAProvincesInfo(){
		System.out.println("====> For each community number of provinces");
		System.out.println("--------------------------------------\n");
		provinceRepository.findAllCAandEachNumberProvinces().stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}

	public void printMechanicsInfoByPlane() {
		System.out.println("====> For each plane, the mechanics were: ");
		System.out.println("--------------------------------------\n");

		List<PlaneMechanicNameSurnameDto> list = this.planeRepository.findPlanesAndMechanicsByJSONField2();

		this.planeRepository.findPlanesAndMechanicsByJSONField()
				.stream().forEach(tuple -> {
					System.out.println("Plane&Mechanic(planeNumber=" + tuple.plateNumber() + ", mechanicName=" + tuple.mechanicName() + ", mechanicSurname=" + tuple.mechanicSurname() + ")\n");
		});
		System.out.println("--------------------------------------\n\n");
	}


//	@Override
//	public List<PlaneDTO> findPlanesAndMechanics() {
//		return this.groupFlatPlaneWithMechanicDTOList(this.planeRepository.findPlaneMechanics());
//	}
//
//	@Override
//	public List<PlaneDTO> findPlanesAndMechanicsByJSONField() {
//		return this.groupFlatPlaneWithMechanicDTOList(this.planeRepository.findPlaneWithMechanicsByJSONField());
//	}
//
//	public List<PlaneDTO> findPlanesAndMechanicsByJSONFieldWithJSONTable() {
//		return this.groupFlatPlaneWithMechanicDTOList(
//				this.planeRepository.findPlaneWithMechanicsByJSONFieldWithJSONTable());
//	}
//
//	private List<PlaneDTO> groupFlatPlaneWithMechanicDTOList(List<FlatPlaneWithMechanicDTO> flatPlaneWithMechanicDTOList) {
//		return flatPlaneWithMechanicDTOList
//				.stream()
//				.collect(Collectors.toMap(
//						FlatPlaneWithMechanicDTO::getId,
//						PlaneDTO::new,
//						(existingOne, newOne) -> {
//							existingOne.getMechanics().addAll(newOne.getMechanics());
//							return existingOne;
//						}))
//				.values()
//				.stream()
//				.collect(Collectors.toList());
//	}

}
