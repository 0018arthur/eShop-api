package eShop.app.service;

import java.util.List;
import java.util.UUID;

import eShop.app.dto.ClientRequest;
import eShop.app.dto.ClientResponse;

public interface ClientService {

	public ClientResponse createClient(ClientRequest clientRequest);
		
	public ClientResponse updateClient(ClientRequest clientRequest, UUID tracking);
	
	public void deleteClient(UUID trackingId);
	
	public ClientResponse getClient(UUID trackingId);
	
	public List<ClientResponse> listeClients(); 
}
