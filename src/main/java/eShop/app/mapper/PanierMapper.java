package eShop.app.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import eShop.app.dto.PanierRequest;
import eShop.app.dto.PanierResponse;
import eShop.app.entity.Panier;

@Component
public class PanierMapper {

	public Panier toEntity(PanierRequest pR) {
		Panier p = new Panier();
		p.setProduits(pR.getProduits());
		p.setTrackingId(UUID.randomUUID());
		return p;
	}
	
	public PanierResponse toResponse(Panier p) {
		PanierResponse pR = new PanierResponse();
		pR.setProduits(p.getProduits());
		pR.setTrackingId(p.getTrackingId());
		return pR;
	}
}
