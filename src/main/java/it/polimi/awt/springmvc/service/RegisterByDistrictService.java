package it.polimi.awt.springmvc.service;
import java.util.List;

import it.polimi.awt.springmvc.domain.*;


public interface RegisterByDistrictService {
	
	public Boolean saveRegisterByDistrict(RegisterByDistrict registerbyDistrict);
	public Boolean saveRegistersByDistrict(List<RegisterByDistrict> registersByDistrict);
	public List<RegisterByDistrict> mapIntoRegisterByDistrict(List<Register> registers);

}
