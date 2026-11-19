package eShop.app.mapper;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import eShop.app.dto.CommandeRequest;
import eShop.app.dto.CommandeResponse;
import eShop.app.entity.Commande;
import eShop.app.repository.ClientRepository;
import eShop.app.repository.PanierRepository;

@Component
public class CommandeMapper {
	
	private ClientRepository clientRepository;
	private PanierRepository panierRepository;
	
	public CommandeMapper(ClientRepository clientRepository, PanierRepository panierRepository) {
		this.clientRepository = clientRepository;
		this.panierRepository = panierRepository;
	}
	
	public Commande toEntity(CommandeRequest cR) {
		Commande c = new Commande();
		c.setNom(cR.getNom());
		c.setClient(clientRepository.findByTrackingId(cR.getClient()).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas")));
		c.setModeReglement(cR.getModeReglement());
		c.setPanier(panierRepository.findByTrackingId(cR.getPanier()).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas")));
		c.setMontantTotal(cR.getMontantTotal());
		c.setTrackingId(UUID.randomUUID());
		c.setDateHeure(LocalDateTime.now());
		c.setStatut(cR.getStatut());
		return c;
	}
	
	public CommandeResponse toResponse(Commande c) {
		CommandeResponse cR = new CommandeResponse();
		cR.setNomCommande(c.getNom());
		cR.setClient(c.getClient());
		cR.setModeReglement(c.getModeReglement());
		cR.setProduits(c.getPanier().getProduits());
		cR.setMontantTotal(c.getMontantTotal());
		cR.setStatut(c.getStatut());
		return cR;
	}
}
