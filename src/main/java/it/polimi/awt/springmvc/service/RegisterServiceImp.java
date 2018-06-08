package it.polimi.awt.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polimi.awt.springmvc.domain.Register;
import it.polimi.awt.springmvc.repository.RegisterRepository;

@Service
public class RegisterServiceImp implements RegisterService{
	 
	private RegisterRepository registerRepository;
	
	@Autowired 
	public RegisterServiceImp(RegisterRepository registerRepository) {
		this.registerRepository = registerRepository;
	}


	public Boolean saveRegister(Register register) {
		Register r = registerRepository.insert(register);
		if (r !=null)
			return true;
		else
			return false;
	}


	@Override
	public List<Register> retrieveRegisterByMeteringPointName(String meteringPointName) {
		return registerRepository.findByMeteringPointName(meteringPointName);
	}



	public Boolean saveRegisters(List<Register> registers) {
		List<Register> r = registerRepository.insert(registers);
		if (r !=null)
			return true;
		else
			return false;
	}

}
