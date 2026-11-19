package eShop.app.serviceImpl;


import org.springframework.stereotype.Service;

import eShop.app.entity.Utilisateur;
import eShop.app.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UtilisateurService {
	
	    private final UtilisateurRepository utilisateurRepository;

	    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
	        this.utilisateurRepository = utilisateurRepository;
	    }

	    public List<Utilisateur> allUsers() {
	        List<Utilisateur> users = new ArrayList<>();

	        utilisateurRepository.findAll().forEach(users::add);

	        return users;
	    }
	
}
