package jh.mastercloud.persistence.relational_persistence.dtos.mysql;

import jh.mastercloud.persistence.relational_persistence.entities.mysql.Mechanic;
import org.springframework.beans.factory.annotation.Value;

public interface PlaneMechanicNameSurnameInterfaceDto {

	String plateNumber();
	String mechanicName();
	String mechanicSurname();


}
