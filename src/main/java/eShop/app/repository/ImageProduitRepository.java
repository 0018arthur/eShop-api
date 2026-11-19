package eShop.app.repository;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eShop.app.entity.ImageProduit;

public interface ImageProduitRepository extends JpaRepository<ImageProduit, Long>{
	
	@Query("SELECT i FROM ImageProduit i WHERE i.produit.trackingId= :x")
	List<ImageProduit> findAllImagesParProduit(@Param("x") UUID trackingId);
}
