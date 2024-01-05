import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CompteManager {
	 private ArrayList<Compte> comptes;
	 private String FICHIER_COMPTES = "fichier_comptes.csv";

	 public CompteManager() {
	    this.comptes = new ArrayList<>();
	    //comptes.add(new Compte("admin@cnam.fr", "admin", "admin"));
	 } 
	 
	    public boolean authentifier(String email, String motDePasse) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_COMPTES))) {
	            String ligne;

	            while ((ligne = reader.readLine()) != null) {
	                String[] elements = ligne.split(";");
	                String emailEnregistre = elements[0];
	                String motDePasseEnregistre = elements[1];

	                if (emailEnregistre.equals(email) && motDePasseEnregistre.equals(motDePasse)) {
	                    // L'authentification réussit
	                    return true;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // L'authentification échoue
	        return false;
	    }
	 
	 public boolean compteExiste(String email) {
	    chargerComptes(); // Charger les comptes depuis le fichier
	    for (Compte compte : comptes) {
	         if (compte.getEmail().equals(email)) {
	              return true;
	          }
	      }
	     return false;
	 }

	private void chargerComptes() {
	    //comptes = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(this.FICHIER_COMPTES))) {
	        String ligne;

	        while ((ligne = reader.readLine()) != null) {
	            String[] elements = ligne.split(";");
	            Compte compte = new Compte(elements[0], elements[1], elements[2]);
	            comptes.add(compte);
	         }
	    } catch (FileNotFoundException e) {
	        System.out.println("Le fichier des comptes n'existe pas. Création du fichier des comptes.");
	        creerFichierComptes();
	        chargerComptes(); // Essayez de charger à nouveau après la création du fichier

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	  }
	 
    public void sauvegarderComptes() {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.FICHIER_COMPTES))) {
	       for (Compte compte : comptes) {
	           writer.write(compte.getEmail() + ";" + compte.getMotDePasse() + ";" + compte.getRole());
	           writer.newLine();
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Le fichier des comptes n'existe pas. Création du fichier des comptes.");
	        creerFichierComptes();
	        chargerComptes(); // Essayez de charger à nouveau après la création du fichier
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
	 }

    private void creerFichierComptes() {
        try {
            File fichier = new File(FICHIER_COMPTES);
            if (fichier.createNewFile()) {
                System.out.println("Fichier des comptes créé avec succès : " + fichier.getAbsolutePath());
            } else {
                System.out.println("Le fichier des comptes existe déjà : " + fichier.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	public void ajouterAdministrateur(String email, String motDePasse) {
	        Compte admin = new Compte(email, motDePasse, "admin");
	        comptes.add(admin);
	        sauvegarderComptes();
	        System.out.println("Administrateur ajouté avec succès.");
	 }

    public void ajouterCompte(Compte compte) {
	        comptes.add(compte);
	        sauvegarderComptes();
	 }
	    
	public void ajouterParticulier(String email, String motDePasse) {
		    Compte admin = new Compte(email, motDePasse, "user");
		    comptes.add(admin);
		    sauvegarderComptes();
		    System.out.println("Utilisateur ajouté avec succès.");
     }	
	
    boolean isAdmin(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_COMPTES))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] infosCompte = ligne.split(";");
                if (infosCompte.length >= 3) {
                    String emailCompte = infosCompte[0];
                    String motDePasse = infosCompte[1];
                    String role = infosCompte[2];

                    if (email.equals(emailCompte) && "admin".equals(role)) {
                        return true; // L'utilisateur est un administrateur
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }

        return false; // L'utilisateur n'est pas un administrateur ou une erreur s'est produite
    }
}
