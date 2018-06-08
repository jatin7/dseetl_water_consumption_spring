package it.polimi.awt.springmvc.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import it.polimi.awt.springmvc.domain.BuildingSmartMeter;

@Repository
public class JpaBuildingSmartMeterRepository implements BuildingSmartMeterRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public BuildingSmartMeter findBuildingSmartMeterBySmartMeterId(String smartMeterId) {
		return em.find(BuildingSmartMeter.class, smartMeterId);
	}
}
