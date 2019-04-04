package pl.gregrad.myhome.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.gregrad.myhome.entity.Consumption;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
	
	@Query("SELECT c FROM Consumption c WHERE c.type = :type")
	List<Consumption> consumptionsByType (@Param("type") String type);
	
	
}
