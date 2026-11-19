package eShop.app.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import eShop.app.dto.ProduitRequest;
import eShop.app.dto.ProduitResponse;
import eShop.app.entity.Produit;
import eShop.app.mapper.ProduitMapper;
import eShop.app.repository.CategorieRepository;
import eShop.app.repository.ProduitRepository;
import eShop.app.service.ProduitService;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProduitServiceImpl implements ProduitService{
		
	private ProduitMapper produitMapper;
	private CategorieRepository categorieRepository;
	private ProduitRepository produitRepository;
	
	public ProduitServiceImpl(ProduitMapper produitMapper, CategorieRepository categorieRepository, ProduitRepository produitRepository) {
		this.produitMapper = produitMapper;
		this.categorieRepository = categorieRepository;
		this.produitRepository = produitRepository;
		}
	
	public ProduitResponse createProduit(ProduitRequest produitRequest) {
		Produit p = produitMapper.toEntity(produitRequest);
		Produit pr = produitRepository.save(p);
		return produitMapper.toResponse(pr);
 	};
	
	public ProduitResponse updateProduit(ProduitRequest pR, UUID trackingId) {
		Produit p = produitRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		p.setNom(pR.getNom());
		p.setDescription(pR.getDescription());
		p.setQuantite(pR.getQuantite());
		p.setPrixUnitaire(pR.getPrixUnitaire());
		p.setCategorie(categorieRepository.findByTrackingId(pR.getCategorie()).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas")));
		Produit pr = produitRepository.save(p);
		return produitMapper.toResponse(pr);
	};
	
	public void deleteProduit(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("Le produit n'existe pas");
		}
		Produit p = produitRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		produitRepository.delete(p);
	};
	
	public List<ProduitResponse> listeProduits(){
		return produitRepository.findAll()
				.stream()
				.map(produitMapper::toResponse)
				.toList();
	};
	
	public ProduitResponse getProduit(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("Le produit n'existe pas");
		}
		Produit p = produitRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		return produitMapper.toResponse(p);
	};
}
