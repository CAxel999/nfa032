public class Compte {
    private String email;
    private String motdepasse;
    private String role;
    public Compte(){}
    public Compte(String email, String motdepasse, String role){
        this.email = email;
        this.motdepasse = motdepasse;
        this.role = role;
    }
    public void setEmail(String email){
      this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setMotdepasse(String motdepasse){
        this.motdepasse = motdepasse;
    }
    public String getMotdepasse(){
        return this.motdepasse;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }
}
