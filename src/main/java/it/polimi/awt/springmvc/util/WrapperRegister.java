package it.polimi.awt.springmvc.util;

import java.util.ArrayList;
import java.util.List;

import it.polimi.awt.springmvc.domain.Register;

public class WrapperRegister {

	private List<Register> registers ;
	private List<Register> negativeRegisters;
	private List<Register> highRegisters ;
	
	public WrapperRegister() {
		registers = new ArrayList<Register>();
		negativeRegisters = new ArrayList<Register>();
		highRegisters = new ArrayList<Register>();
	}
	
	public List<Register> getRegisters() {
		return registers;
	}
	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}
	public List<Register> getNegativeRegisters() {
		return negativeRegisters;
	}
	public void setNegativeRegisters(List<Register> negativeRegisters) {
		this.negativeRegisters = negativeRegisters;
	}
	public List<Register> getHighRegisters() {
		return highRegisters;
	}
	public void setHighRegisters(List<Register> highRegisters) {
		this.highRegisters = highRegisters;
	}
	
	
}
