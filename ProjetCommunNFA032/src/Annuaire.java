import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Annuaire {

	private ArrayList<Personne> annuaires;
    private CompteManager compteManager;
    private String FICHIER_ANNUAIRE = "fichier_annuaire.csv";

    public Annuaire() {
        this.annuaires = new ArrayList<>();
    }
    
    public Annuaire(CompteManager compteManager) {
        this.compteManager = compteManager;
        this.annuaires = new ArrayList<>();
    }

    public void sauvegarderAnnuaire() {
    	
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.FICHIER_ANNUAIRE))) {
            for (Personne personne : annuaires) {
                writer.write(
                        personne.getNom() + ";" +
                        personne.getPrenom() + ";" +
                        personne.getEmail() + ";" +
                        personne.getAdressePostale() + ";" +
                        personne.getDateNaissance() + ";" +
                        personne.getProfil() + ";" +
                        personne.getDateAjout() + ";" +
                        personne.getDateMaj() + "\n");
            }
	    } catch (FileNotFoundException e) {
	        System.out.println("Le fichier des comptes n'existe pas. Création du fichier...");
	        creerFichierComptes();
	        chargerAnnuaire(); // Essayez de charger à nouveau après la création du fichier

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void creerFichierComptes() {
        try {
            File fichier = new File(FICHIER_ANNUAIRE);
            if (fichier.createNewFile()) {
                System.out.println("Fichier des comptes créé avec succès : " + fichier.getAbsolutePath());
            } else {
                System.out.println("Le fichier des comptes existe déjà : " + fichier.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void chargerAnnuaire() {
    	annuaires = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.FICHIER_ANNUAIRE))) {
            String ligne;

            while ((ligne = reader.readLine()) != null) {
                String[] elements = ligne.split(";");
                
                // Extraire les informations nécessaires du tableau d'éléments
                String nom = elements[2];
                String prenom = elements[3];
                String email = elements[4];
                String adressePostale = elements[5];
                String dateNaissance = elements[6];
                String profil = elements[7];
                String dateAjout = elements[8];
                String dateMaj = elements[9];
                
                // Créer un objet Particulier avec les informations extraites
                Personne personne = new Personne(nom, prenom, email, adressePostale, dateNaissance, profil, dateAjout, dateMaj);
                
                // Ajouter le particulier à la liste
                annuaires.add(personne);
            }
	    } catch (FileNotFoundException e) {
	        System.out.println("Le fichier des comptes n'existe pas. Création du fichier...");
	        creerFichierComptes();
	        //charger(); // Essayez de charger à nouveau après la création du fichier

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void ajouterParticulier(String email, String motDePasse) {
        chargerAnnuaire(); // Charger l'annuaire depuis le fichier

            // Vérifier si le compte existe déjà
            if (!compteManager.compteExiste(email)) {
                // Demander les informations sur le particulier
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nom : ");
                String nom = scanner.nextLine();

                System.out.print("Prénom : ");
                String prenom = scanner.nextLine();

                System.out.print("Adresse Postale : ");
                String adressePostale = scanner.nextLine();

                System.out.print("Date de Naissance : ");
                String dateNaissance = scanner.nextLine();

                System.out.print("Profil (Auditeurs, Enseignants, Direction) : ");
                String profil = scanner.nextLine();

                // Ajouter le compte
                compteManager.ajouterParticulier(email, motDePasse);
                
                // Créer un objet Particulier avec les informations saisies
                Personne particulier = new Personne(nom, prenom, email, adressePostale, dateNaissance, profil, "", "");
                
                // Ajouter le particulier à l'annuaire
                annuaires.add(particulier);

                // Sauvegarder l'annuaire
                sauvegarderAnnuaire();
                System.out.println("Particulier ajouté avec succès.");
            } else {
                System.out.println("Echec : Un compte avec cet email existe déjà.");
            }
          }
    

	public ArrayList<Personne> getPersonnes() {
		return annuaires;
	}

	public void setPersonnes(ArrayList<Personne> annuaires) {
		this.annuaires = annuaires;
	}
   
}
