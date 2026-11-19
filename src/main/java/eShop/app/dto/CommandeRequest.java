package eShop.app.dto;


import java.util.UUID;

import eShop.app.entity.Client;
import eShop.app.entity.Panier;
import eShop.app.enums.ModeReglement;
import eShop.app.enums.Statut;


public class CommandeRequest {
	
	private String nom;
	
	private UUID client;

    private ModeReglement modeReglement;
	
    private Statut statut;
	
	private double montantTotal;
	
	private UUID panier;
	
	public CommandeRequest() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public UUID getClient() {
		return client;
	}

	public void setClient(UUID client) {
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

	public UUID getPanier() {
		return panier;
	}

	public void setPanier(UUID panier) {
		this.panier = panier;
	}
	
	
	
}
