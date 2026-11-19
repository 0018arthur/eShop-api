package eShop.app.service;

import java.util.List;
import java.util.UUID;

import eShop.app.dto.CommandeRequest;
import eShop.app.dto.CommandeResponse;

public interface CommandeService {
	
	public CommandeResponse createCommande(CommandeRequest CommandeRequest);
	
	public CommandeResponse updateCommande(CommandeRequest CommandeRequest, UUID tracking);
	
	public void deleteCommande(UUID trackingId);
	
	public CommandeResponse getCommande(UUID trackingId);
	
	public List<CommandeResponse> listeCommandes();
}
