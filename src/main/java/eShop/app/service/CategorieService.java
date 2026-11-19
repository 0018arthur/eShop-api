package eShop.app.service;

import java.util.List;
import java.util.UUID;

import eShop.app.dto.CategorieRequest;
import eShop.app.dto.CategorieResponse;

public interface CategorieService {
	
	public CategorieResponse createCategorie(CategorieRequest categorieRequest);
	
	public CategorieResponse updateCategorie(CategorieRequest categorieRequest, UUID trackingId);
	
	public void deleteCategorie(UUID trackingId);
	
	public List<CategorieResponse> listeCategories();
	
	public CategorieResponse getCategorie(UUID trackingId);
	}
