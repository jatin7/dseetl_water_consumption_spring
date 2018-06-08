package it.polimi.awt.springmvc.repository;


import it.polimi.awt.springmvc.domain.BuildingSmartMeter;

public interface BuildingSmartMeterRepository {
	public BuildingSmartMeter findBuildingSmartMeterBySmartMeterId(String smartMeterId);
}
