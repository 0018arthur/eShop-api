package eShop.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eShop.app.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	
	@Query("SELECT p FROM Produit p WHERE p.trackingId= :x")
	Optional<Produit> findByTrackingId(@Param("x") UUID trackingId);
	
	@Query("SELECT p FROM Produit p ORDER BY p.nom")
	List<Produit> findAllProduitOrderByNom();
}
