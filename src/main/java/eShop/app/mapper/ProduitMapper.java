package eShop.app.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import eShop.app.dto.ProduitRequest;
import eShop.app.dto.ProduitResponse;
import eShop.app.entity.ImageProduit;
import eShop.app.entity.Produit;
import eShop.app.repository.CategorieRepository;

@Component
public class ProduitMapper {
	
	private CategorieRepository categorieRepository;
	
	public ProduitMapper(CategorieRepository categorieRepository) {
			this.categorieRepository = categorieRepository;
	}

	
	public Produit toEntity(ProduitRequest pR) {
		Produit p = new Produit();
		p.setNom(pR.getNom());
		p.setDescription(pR.getDescription());
		p.setQuantite(pR.getQuantite());
		p.setPrixUnitaire(pR.getPrixUnitaire());
		p.setCategorie(categorieRepository.findByTrackingId(pR.getCategorie()).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas")));
		p.setTrackingId(UUID.randomUUID());
		return p;
	}
	
	public ProduitResponse toResponse(Produit p) {
		ProduitResponse pR = new ProduitResponse();
		pR.setNom(p.getNom());
		pR.setDescription(p.getDescription());
		pR.setQuantite(p.getQuantite());
		if(p.getQuantite() > 0) {
			pR.setDisponibilite(true);
		}
		else if(p.getQuantite() == 0){
			pR.setDisponibilite(false);
		}
		pR.setNomCategorie(p.getCategorie().getLibelle());
		pR.setPrixUnitaire(p.getPrixUnitaire());
		pR.setTrackingId(p.getTrackingId());
		if (p.getImages() != null && !p.getImages().isEmpty()) {
	        pR.setImageUrls(p.getImages().stream()
	                .map(ImageProduit::getUrl)
	                .collect(Collectors.toList()));
	    } else {
	        pR.setImageUrls(List.of()); 
	    }
		return pR;
	}
}
