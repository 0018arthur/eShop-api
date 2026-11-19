package eShop.app.dto;

import java.util.List;

import eShop.app.entity.Client;
import eShop.app.entity.Produit;
import eShop.app.enums.ModeReglement;
import eShop.app.enums.Statut;

public class CommandeResponse {
	
	private String nomCommande;
	
	private Client client;

    private ModeReglement modeReglement;
	
    private Statut statut;
	
	private double montantTotal;
	
	private List<Produit> produits;
	
	public CommandeResponse() {
		
	}

	public String getNomCommande() {
		return nomCommande;
	}

	public void setNomCommande(String nomCommande) {
		this.nomCommande = nomCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ModeReglement getModeReglement() {
		return modeReglement;
	}

	public void setModeReglement(ModeReglement modeReglement) {
		this.modeReglement = modeReglement;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}
