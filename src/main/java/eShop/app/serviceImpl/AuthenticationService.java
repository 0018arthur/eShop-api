package eShop.app.serviceImpl;


import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import eShop.app.dto.LoginUserDto;
import eShop.app.dto.RegisterUserDto;
import eShop.app.entity.Utilisateur;
import eShop.app.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;

@Service
public class AuthenticationService {
    private final UtilisateurRepository utilisateurRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
    		UtilisateurRepository utilisateurRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Transactional
    public Utilisateur signup(RegisterUserDto registerUserDto) {
    	Utilisateur utilisateur = new Utilisateur();
    	utilisateur.setNom(registerUserDto.getNom());
    	utilisateur.setPrenom(registerUserDto.getPrenom());
    	utilisateur.setEmail(registerUserDto.getEmail());
    	utilisateur.setRole(registerUserDto.getRoleAsEnum());
    	utilisateur.setTrackingId(UUID.randomUUID());
    	utilisateur.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));

        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return utilisateurRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}