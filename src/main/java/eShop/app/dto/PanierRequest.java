package eShop.app.dto;

import java.util.List;

import eShop.app.entity.Produit;

public class PanierRequest {
	
	private List<Produit> produits;
	
	public PanierRequest() {
		
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}
