package eShop.app.service;

import java.util.List;
import java.util.UUID;

import eShop.app.dto.PanierRequest;
import eShop.app.dto.PanierResponse;

public interface PanierService {
	
	public PanierResponse createPanier(PanierRequest pR);
	
	public PanierResponse updatePanier(PanierRequest pR, UUID trackingId);
	
	public void deletePanier(UUID trackingId);
	
	public PanierResponse getPanier(UUID trackingId);
	
	public List<PanierResponse> listePaniers();
}
