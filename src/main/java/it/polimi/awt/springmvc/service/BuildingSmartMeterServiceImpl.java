package it.polimi.awt.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polimi.awt.springmvc.domain.BuildingSmartMeter;
import it.polimi.awt.springmvc.repository.BuildingSmartMeterRepository;

@Service
public class BuildingSmartMeterServiceImpl implements BuildingSmartMeterService{

	private BuildingSmartMeterRepository buildingSmartMeterRepository;
	
	@Autowired
	public BuildingSmartMeterServiceImpl (BuildingSmartMeterRepository buildingSmartMeterRepository) {
		this.buildingSmartMeterRepository = buildingSmartMeterRepository;
	}
	
	@Override
	public BuildingSmartMeter getBuildingSmartMeterBySmartMeterId(String smartMeterId) {
		
		return buildingSmartMeterRepository.findBuildingSmartMeterBySmartMeterId(smartMeterId);
	}

}
