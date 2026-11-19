package eShop.app.serviceImpl;


import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import eShop.app.dto.PanierRequest;
import eShop.app.dto.PanierResponse;
import eShop.app.entity.Panier;
import eShop.app.mapper.PanierMapper;
import eShop.app.repository.PanierRepository;
import eShop.app.service.PanierService;
import jakarta.transaction.Transactional;


@Transactional
@Service
public class PanierServiceImpl implements PanierService{
	private PanierMapper panierMapper;
	private PanierRepository panierRepository;
	
	public PanierServiceImpl(PanierMapper panierMapper, PanierRepository panierRepository) {
		this.panierMapper = panierMapper;
		this.panierRepository = panierRepository;
		}
	
	public PanierResponse createPanier(PanierRequest panierRequest) {
		Panier p = panierMapper.toEntity(panierRequest);
		Panier pr = panierRepository.save(p);
		return panierMapper.toResponse(pr);
 	};
	
	public PanierResponse updatePanier(PanierRequest pR, UUID trackingId) {
		Panier p = panierRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		p.setProduits(pR.getProduits());
		Panier pr = panierRepository.save(p);
		return panierMapper.toResponse(pr);
	};

	public void deletePanier(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("Le panier n'existe pas");
		}
		Panier p = panierRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		panierRepository.delete(p);
	};

	public List<PanierResponse> listePaniers(){
		return panierRepository.findAll()
				.stream()
				.map(panierMapper::toResponse)
				.toList();
	};

	public PanierResponse getPanier(UUID trackingId) {
		if(trackingId == null){
			throw new RuntimeException("Le panier n'existe pas");
		}
		Panier p = panierRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
			return panierMapper.toResponse(p);
		};
	}

