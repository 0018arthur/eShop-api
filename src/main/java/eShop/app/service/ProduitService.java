package eShop.app.service;

import java.util.List;
import java.util.UUID;

import eShop.app.dto.ProduitRequest;
import eShop.app.dto.ProduitResponse;

public interface ProduitService {
	
	public ProduitResponse createProduit(ProduitRequest produitRequest);
	
	public ProduitResponse updateProduit(ProduitRequest produitRequest, UUID trackingId);
	
	public void deleteProduit(UUID trackingId);
	
	public List<ProduitResponse> listeProduits();
	
	public ProduitResponse getProduit(UUID trackingId);
}
