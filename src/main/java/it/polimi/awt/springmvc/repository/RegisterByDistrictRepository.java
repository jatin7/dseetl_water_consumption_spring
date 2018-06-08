package it.polimi.awt.springmvc.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import it.polimi.awt.springmvc.domain.RegisterByDistrict;

@Repository
public interface RegisterByDistrictRepository extends CassandraRepository<RegisterByDistrict,String>{
}
