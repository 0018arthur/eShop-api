package eShop.app.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import eShop.app.dto.ClientRequest;
import eShop.app.dto.ClientResponse;
import eShop.app.entity.Client;
import eShop.app.mapper.ClientMapper;
import eShop.app.repository.ClientRepository;
import eShop.app.service.ClientService;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class ClientServiceImpl implements ClientService{
		
	private ClientMapper clientMapper;
	private ClientRepository clientRepository;
	
	public ClientServiceImpl(ClientMapper clientMapper, ClientRepository clientRepository) {
		this.clientMapper = clientMapper;
		this.clientRepository = clientRepository;
		}
	
	public ClientResponse createClient(ClientRequest clientRequest) {
		Client c = clientMapper.toEntity(clientRequest);
		Client cl = clientRepository.save(c);
		return clientMapper.toResponse(cl);
 	};
	
	public ClientResponse updateClient(ClientRequest clR, UUID trackingId) {
		Client c = clientRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		c.setNom(clR.getNom());
		c.setPrenom(clR.getPrenom());
		c.setEmail(clR.getEmail());
		c.setTelephone(clR.getTelephone());
		c.setAdresse(clR.getAdresse());
		Client cl = clientRepository.save(c);
		return clientMapper.toResponse(cl);
	};
	
	public void deleteClient(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("Le client n'existe pas");
		}
		Client c = clientRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		clientRepository.delete(c);
	};
	
	public List<ClientResponse> listeClients(){
		return clientRepository.findAll()
				.stream()
				.map(clientMapper::toResponse)
				.toList();
	};
	
	public ClientResponse getClient(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("Le produit n'existe pas");
		}
		Client p = clientRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		return clientMapper.toResponse(p);
	};
}

