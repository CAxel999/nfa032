
public class Personne {
	
    private String nom;
    private String prenom;
    private String email;
    private String adressePostale;
    private String dateNaissance;
    private String profil;
    private String dateAjout;
    private String dateMaj;
    
	public Personne(String nom, String prenom, String email, String adressePostale, String dateNaissance, String profil,
			String dateAjout, String dateMaj) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adressePostale = adressePostale;
		this.dateNaissance = dateNaissance;
		this.profil = profil;
		this.dateAjout = dateAjout;
		this.dateMaj = dateMaj;
	}

    public String toCsvString() {
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s",
                nom, prenom, email, adressePostale, dateNaissance, profil, dateAjout, dateMaj);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdressePostale() {
		return adressePostale;
	}

	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(String dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(String dateMaj) {
		this.dateMaj = dateMaj;
	}
    
}
