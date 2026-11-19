package eShop.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eShop.app.entity.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long>{
	
	@Query("SELECT p FROM Panier p WHERE p.trackingId= :x")
	Optional<Panier> findByTrackingId(@Param("x") UUID trackingId);
	
	@Query("SELECT p FROM Panier p")
	List<Panier> findAllPanier();
}
