package com.dna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dna.model.SerVivo;

public interface ISerVivoRepository extends JpaRepository<SerVivo, Long> {

	@Query(value = "select distinct \r\n"
			+ "(select count(simio) from ser_vivo where simio=1 )as 'count_mutant_dna',\r\n"
			+ "(select count(simio) from ser_vivo where simio=0 )as 'count_human_dna', \r\n"
			+ "(select count(simio) from ser_vivo where simio=1 )/(select count(simio) from ser_vivo where simio=0 ) as ratio\r\n"
			+ " from ser_vivo ;", 
			  nativeQuery = true)
	public String[]rate();
	
}
