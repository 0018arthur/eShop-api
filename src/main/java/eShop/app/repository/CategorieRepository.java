package eShop.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eShop.app.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
	
	@Query("SELECT c FROM Categorie c WHERE c.trackingId= :x")
	Optional<Categorie> findByTrackingId(@Param("x") UUID TrackingId);
	
	@Query("SELECT c FROM Categorie c ORDER BY c.libelle")
	List<Categorie> findAllCategorieOrderByLibelle();
}
