package eShop.app.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import eShop.app.dto.CategorieRequest;
import eShop.app.dto.CategorieResponse;
import eShop.app.entity.Categorie;


@Component
public class CategorieMapper {
	
	
	public Categorie toEntity(CategorieRequest cR) {
		Categorie c = new Categorie();
		c.setLibelle(cR.getLibelle());
		c.setTrackingId(UUID.randomUUID());
		return c;
	}
	
	public CategorieResponse toResponse(Categorie c) {
		CategorieResponse cR = new CategorieResponse();
		cR.setLibelle(c.getLibelle());
		cR.setTrackingId(c.getTrackingId());
		return cR;
	}

}
