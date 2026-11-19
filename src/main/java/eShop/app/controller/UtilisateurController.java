package eShop.app.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eShop.app.entity.Utilisateur;
import eShop.app.serviceImpl.UtilisateurService;

import java.util.List;

@RequestMapping("eShop/v1/users")
@RestController
public class UtilisateurController {
	
	    private final UtilisateurService utilisateurService;

	    public UtilisateurController(UtilisateurService utilisateurService) {
	        this.utilisateurService = utilisateurService;
	    }

	    @GetMapping("/me")
	    public ResponseEntity<Utilisateur> authenticatedUser() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        Utilisateur currentUser = (Utilisateur) authentication.getPrincipal();

	        return ResponseEntity.ok(currentUser);
	    }

	    @GetMapping("/")
	    public ResponseEntity<List<Utilisateur>> allUsers() {
	        List <Utilisateur> users = utilisateurService.allUsers();

	        return ResponseEntity.ok(users);
	    }
	
}
