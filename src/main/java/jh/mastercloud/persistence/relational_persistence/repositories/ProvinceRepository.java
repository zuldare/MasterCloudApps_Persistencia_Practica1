package jh.mastercloud.persistence.relational_persistence.repositories;

import java.util.List;
import jh.mastercloud.persistence.relational_persistence.dtos.mongodb.CAInformationDto;
import jh.mastercloud.persistence.relational_persistence.entities.mongodb.Province;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvinceRepository extends MongoRepository<Province, String> {

	@Aggregation(pipeline = {
			"{ $group: { _id: '$CA', provincias: { $push: '$Nombre' }}}",
			"{ $project: { _id: { $ifNull: [ '$_id', 'Sin Comunidad' ]}, total: { $size: '$provincias' }}}",
			"{ $sort : { _id : 1 }}"})
	List<CAInformationDto> findAllCAandEachNumberProvinces();
}
