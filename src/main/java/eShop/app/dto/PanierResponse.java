package eShop.app.dto;

import java.util.List;
import java.util.UUID;

import eShop.app.entity.Produit;

public class PanierResponse {
	
	private UUID trackingId;
	
	private List<Produit> produits;
	
	public PanierResponse() {
		
	}

	public UUID getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}
