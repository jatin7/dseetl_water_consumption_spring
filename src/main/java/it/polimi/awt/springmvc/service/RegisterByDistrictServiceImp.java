package it.polimi.awt.springmvc.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polimi.awt.springmvc.domain.BuildingSmartMeter;
import it.polimi.awt.springmvc.domain.Register;
import it.polimi.awt.springmvc.domain.RegisterByDistrict;
import it.polimi.awt.springmvc.repository.RegisterByDistrictRepository;

@Service
public class RegisterByDistrictServiceImp implements RegisterByDistrictService{
	 
	private RegisterByDistrictRepository registerByDistrictRepository;
	
	@Autowired 
	public RegisterByDistrictServiceImp(RegisterByDistrictRepository registerByDistrictRepository) {
		this.registerByDistrictRepository = registerByDistrictRepository;
	}

	@Autowired 
	BuildingSmartMeterService buildingSmartMeterService;
	
	public Boolean saveRegisterByDistrict(RegisterByDistrict registerByDistrict) {
		RegisterByDistrict r = registerByDistrictRepository.insert(registerByDistrict);
		if (r !=null)
			return true;
		else
			return false;
	}

	public Boolean saveRegistersByDistrict(List<RegisterByDistrict> registersByDistrict) {
		List<RegisterByDistrict> r = registerByDistrictRepository.insert(registersByDistrict);
		if (r !=null)
			return true;
		else
			return false;
	}


	@Override
	public List<RegisterByDistrict> mapIntoRegisterByDistrict(List<Register> registers) {
		
		List<RegisterByDistrict> registersByDistrict = new ArrayList<RegisterByDistrict>();
		System.out.println("--Inizio procedura per district...");
		for (Register register : registers) {
			
			BuildingSmartMeter buildingSmartMeter = buildingSmartMeterService.getBuildingSmartMeterBySmartMeterId(
								register.getMeteringPointName());
			
			if (buildingSmartMeter != null && buildingSmartMeter.getDistrictOid() != null ) {
				
				RegisterByDistrict registerByDistrict = new RegisterByDistrict(
				
					//partition keys
					buildingSmartMeter.getDistrictOid().toString(),
					register.getTimestamp().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getYear(),
	
					register.getTimestamp(),
					register.getMeteringPointId(),
					register.getMeteringPointName(),
					register.getStatus(),
					register.getUnit(),
					(register.getValue() * register.getTransformerRatio())
				);

				registersByDistrict.add(registerByDistrict);
			}
		}
		
		return registersByDistrict;
	}

}
