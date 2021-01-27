package com.dna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dna.model.Data;
import com.dna.model.SerVivo;


public interface ISerVivoRepository extends JpaRepository<SerVivo, Long> {

	@Query(value = "select distinct new com.dna.model.Data( \r\n"
			+ "(select count(simio) from SerVivo where simio=1 ),\r\n"
			+ "(select count(simio) from SerVivo where simio=0 ), \r\n"
			+ "( (select count(simio)*1.0 from SerVivo where simio=1 )/(select count(simio)*1.0 from SerVivo where simio=0) )\r\n"
			+ " )from SerVivo a"
			, nativeQuery = false)
	
	
	public Data rate();
	
}
