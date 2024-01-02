public class Annuaire {
    private String nom;
    private String prenom;
    private String email;
    private String adressePostale;
    private String dateNaissance;
    private String profil;
    private String dateAjout;
    private String dateMaj;

    public Annuaire(){}
    public Annuaire(String nom, String prenom, String email, String adressePostale, String dateNaissance, String profil, String dateAjout, String dateMaj) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adressePostale = adressePostale;
        this.dateNaissance = dateNaissance;
        this.profil = profil;
        this.dateAjout = dateAjout;
        this.dateMaj = dateMaj;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return this.nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setAdressePostale(String adressePostale){
        this.adressePostale = adressePostale;
    }
    public String getAdressePostale(){
        return this.adressePostale;
    }
    public void setDateNaissance(String dateNaissance){
        this.dateNaissance = dateNaissance;
    }
    public String getDateNaissance(){
        return this.dateNaissance;
    }
    public void setProfil(String profil){
        this.profil = profil;
    }
    public String getProfil(){
        return this.profil;
    }
    public void setDateAjout(String dateAjout){
        this.dateAjout = dateAjout;
    }
        public String getDateAjout(){
        return this.dateAjout;
    }
    public void setDateMaj(String dateMaj){
        this.dateMaj = dateMaj;
    }
    public String getDateMaj(){
        return this.dateMaj;
    }
}