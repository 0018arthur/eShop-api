package eShop.app.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import eShop.app.dto.CategorieRequest;
import eShop.app.dto.CategorieResponse;
import eShop.app.entity.Categorie;
import eShop.app.mapper.CategorieMapper;
import eShop.app.repository.CategorieRepository;
import eShop.app.service.CategorieService;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class CategorieServiceImpl implements CategorieService{
		
	private CategorieMapper categorieMapper;
	private CategorieRepository categorieRepository;
	
	public CategorieServiceImpl(CategorieMapper categorieMapper, CategorieRepository categorieRepository) {
		this.categorieMapper = categorieMapper;
		this.categorieRepository = categorieRepository;
	}
	
	public CategorieResponse createCategorie(CategorieRequest categorieRequest) {
		Categorie c = categorieMapper.toEntity(categorieRequest);
		Categorie ca = categorieRepository.save(c);
		return categorieMapper.toResponse(ca);
	};
	
	public CategorieResponse updateCategorie(CategorieRequest cR, UUID trackingId) {
		Categorie c = categorieRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		c.setLibelle(cR.getLibelle());
		Categorie ca = categorieRepository.save(c);
		return categorieMapper.toResponse(ca);
	};
	
	public void deleteCategorie(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("La categorie n'existe pas");
		}
		Categorie c = categorieRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		categorieRepository.delete(c);
	};
	
	public List<CategorieResponse> listeCategories(){
		return categorieRepository.findAllCategorieOrderByLibelle()
				.stream()
				.map(categorieMapper::toResponse)
				.toList();
		
	};
		
	public CategorieResponse getCategorie(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("La categorie n'existe pas");
		}
		Categorie c = categorieRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		return categorieMapper.toResponse(c);
	};
	
}
