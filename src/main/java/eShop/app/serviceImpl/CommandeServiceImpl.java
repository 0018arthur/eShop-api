package eShop.app.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import eShop.app.dto.CommandeRequest;
import eShop.app.dto.CommandeResponse;
import eShop.app.entity.Commande;
import eShop.app.mapper.CommandeMapper;
import eShop.app.repository.CategorieRepository;
import eShop.app.repository.ClientRepository;
import eShop.app.repository.CommandeRepository;
import eShop.app.repository.PanierRepository;
import eShop.app.service.CommandeService;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class CommandeServiceImpl implements CommandeService{
		
	private CommandeMapper commandeMapper;
	private CommandeRepository commandeRepository;
	private PanierRepository panierRepository;
	private ClientRepository clientRepository;
	
	public CommandeServiceImpl(CommandeMapper commandeMapper, CommandeRepository commandeRepository, PanierRepository panierRepository, ClientRepository clientRepository) {
		this.commandeMapper = commandeMapper;
		this.commandeRepository = commandeRepository;
		this.panierRepository = panierRepository;
		this.clientRepository = clientRepository;
	}
	
	public CommandeResponse createCommande(CommandeRequest commandeRequest) {
		Commande c = commandeMapper.toEntity(commandeRequest);
		Commande co = commandeRepository.save(c);
		return commandeMapper.toResponse(co);
 	};
	
	public CommandeResponse updateCommande(CommandeRequest cR, UUID trackingId) {
		Commande c = commandeRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		c.setNom(cR.getNom());
		c.setClient(clientRepository.findByTrackingId(cR.getClient()).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas")));
		c.setModeReglement(cR.getModeReglement());
		c.setPanier(panierRepository.findByTrackingId(cR.getPanier()).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas")));
		c.setMontantTotal(cR.getMontantTotal());
		c.setTrackingId(UUID.randomUUID());
		c.setDateHeure(LocalDateTime.now());
		c.setStatut(cR.getStatut());
		Commande co = commandeRepository.save(c);
		return commandeMapper.toResponse(co);
	};
	
	public void deleteCommande(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("La commande n'existe pas");
		}
		Commande c = commandeRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		commandeRepository.delete(c);
	};
	
	public List<CommandeResponse> listeCommandes(){
		return commandeRepository.findAll()
				.stream()
				.map(commandeMapper::toResponse)
				.toList();
	};
	
	public CommandeResponse getCommande(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("La commande n'existe pas");
		}
		Commande c = commandeRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		return commandeMapper.toResponse(c);
	};
}
