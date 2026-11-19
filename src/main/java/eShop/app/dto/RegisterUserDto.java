package eShop.app.dto;

import eShop.app.enums.Role;

public class RegisterUserDto {
	
	private String email;
    
    private String password;
    
    private String nom;
    
    private String role;
    
    private String prenom;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Role getRoleAsEnum() {
        return Role.valueOf(this.role.toUpperCase());
    }

	public void setRole(String role) {
		this.role = role;
	}
    
	
    
}
