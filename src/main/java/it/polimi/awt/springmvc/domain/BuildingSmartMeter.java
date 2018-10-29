package it.polimi.awt.springmvc.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Entity
 @Table(name="building_smart_meter")
public class BuildingSmartMeter {
	@Id String smartMeterId;
	Integer districtOid;
	
	public BuildingSmartMeter() {
		
	}
}
