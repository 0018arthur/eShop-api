package eShop.app.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import eShop.app.dto.ClientRequest;
import eShop.app.dto.ClientResponse;
import eShop.app.entity.Client;

@Component
public class ClientMapper {
	
	
	public Client toEntity(ClientRequest cR) {
		Client c = new Client();
		c.setNom(cR.getNom());
		c.setPrenom(cR.getPrenom());
		c.setEmail(cR.getEmail());
		c.setTelephone(cR.getTelephone());
		c.setAdresse(cR.getAdresse());
		c.setTrackingId(UUID.randomUUID());
		return c;
	}
	
	public ClientResponse toResponse(Client c) {
		ClientResponse cR = new ClientResponse();
		cR.setNom(c.getNom());
		cR.setPrenom(c.getPrenom());
		cR.setEmail(c.getEmail());
		cR.setTelephone(c.getTelephone());
		cR.setAdresse(c.getAdresse());
		cR.setTrackingId(UUID.randomUUID());
		return cR;
	}
}
