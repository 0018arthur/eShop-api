package eShop.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eShop.app.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query("SELECT c FROM Client c WHERE c.trackingId= :x")
	Optional<Client> findByTrackingId(@Param("x") UUID trackingId);
	
	@Query("SELECT c FROM Client c ORDER BY c.nom")
	List<Client> findAllClientOrderByNom();
}
