package it.polimi.awt.springmvc.repository;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import it.polimi.awt.springmvc.mapper.EnergyDataExchangeFormatType;

@Repository
public interface EnergyDataExchangeFormatRepository {
	public EnergyDataExchangeFormatType importEnergyData(String path);
	public Resource[] getXMLFilesFromFileSystem();
}
