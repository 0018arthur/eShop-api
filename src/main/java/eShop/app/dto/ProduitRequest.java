package eShop.app.dto;

import java.util.List;
import java.util.UUID;

public class ProduitRequest {
	
private String nom;
	
	private String description;
	
	private int quantite;
	
	private double prixUnitaire;
	
	private List<String> imageUrls;
	
	private  UUID categorie;
	
	public ProduitRequest() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public UUID getCategorie() {
		return categorie;
	}

	public void setCategorie(UUID categorie) {
		this.categorie = categorie;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	
	
	
	
}
