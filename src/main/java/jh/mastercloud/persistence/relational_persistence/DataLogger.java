package jh.mastercloud.persistence.relational_persistence;

import jh.mastercloud.persistence.relational_persistence.repositories.ProvinceRepository;
import org.springframework.stereotype.Component;

@Component
public class DataLogger {

	private final ProvinceRepository provinceRepository;

	public DataLogger(ProvinceRepository provinceRepository) {
		this.provinceRepository = provinceRepository;
	}


	public void printAllProvinces(){
		System.out.println("====> Provinces");
		System.out.println("--------------------------------------\n");
		provinceRepository.findAll().stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}

	public void printCAProvincesInfo(){
		System.out.println("====> Provinces");
		System.out.println("--------------------------------------\n");
		provinceRepository.findAllCAandEachNumberProvinces().stream().forEach(System.out::println);
		System.out.println("--------------------------------------\n\n");
	}
}
