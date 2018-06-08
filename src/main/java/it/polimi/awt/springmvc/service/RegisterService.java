package it.polimi.awt.springmvc.service;
import java.util.List;

import it.polimi.awt.springmvc.domain.*;


public interface RegisterService {
	
	public Boolean saveRegister(Register register);
	public Boolean saveRegisters(List<Register> registers);
	public List<Register> retrieveRegisterByMeteringPointName (String meteringPointName);

}
