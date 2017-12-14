package com.metrotraining.excuse;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PontajRepository extends JpaRepository<Pontaj, Long>{
	public List<Pontaj> findAll();
	@Query(value="SELECT sum(difference) FROM pontaj", nativeQuery = true)
	public long findSumDifference();

}
