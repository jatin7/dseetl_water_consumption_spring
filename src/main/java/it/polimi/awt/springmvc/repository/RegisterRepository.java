package it.polimi.awt.springmvc.repository;
import it.polimi.awt.springmvc.domain.Register;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends CassandraRepository<Register,String>{
	  List<Register> findByMeteringPointName(final String meteringPointName);
}
