
public class Compte {
	
    private String email;
    private String motDePasse;
    private String role;
    
	public Compte(String email, String motDePasse, String role) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
