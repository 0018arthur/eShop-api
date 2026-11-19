package eShop.app.dto;

import java.util.UUID;

public class CategorieResponse {
	
	private UUID trackingId;
	
	private String libelle;
	
	public CategorieResponse() {
		
	}

	public UUID getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
