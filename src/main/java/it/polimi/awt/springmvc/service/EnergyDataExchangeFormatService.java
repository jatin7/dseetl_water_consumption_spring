package it.polimi.awt.springmvc.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import it.polimi.awt.springmvc.mapper.EnergyDataExchangeFormatType;
import it.polimi.awt.springmvc.mapper.RegisterType;
import it.polimi.awt.springmvc.util.WrapperRegister;

public interface EnergyDataExchangeFormatService {

	public EnergyDataExchangeFormatType getEnergyDataExchangeFormatFromFile(String path);
	public Map<String, List<RegisterType>> groupByMeteringPointName(EnergyDataExchangeFormatType energyDataExchangeFormatType);
	public WrapperRegister computeDelta(Map<String, List<RegisterType>> registersGrouped);
	public WrapperRegister loadXMLFiles() throws IOException;
}