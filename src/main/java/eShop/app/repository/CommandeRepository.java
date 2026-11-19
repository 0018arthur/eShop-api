package eShop.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eShop.app.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{
	
	@Query("SELECT c FROM Commande c WHERE c.trackingId= :x")
	Optional<Commande> findByTrackingId(@Param("x") UUID trackingId);
	
	@Query("SELECT c FROM Commande c ORDER BY c.nom")
	List<Commande> findAllCommandeOrderByNom();
}
