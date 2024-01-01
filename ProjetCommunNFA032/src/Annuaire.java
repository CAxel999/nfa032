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
	        System.out.println("Le fichier des comptes n'existe pas. Cr�ation du fichier...");
	        creerFichierComptes();
	        chargerAnnuaire(); // Essayez de charger � nouveau apr�s la cr�ation du fichier

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void creerFichierComptes() {
        try {
            File fichier = new File(FICHIER_ANNUAIRE);
            if (fichier.createNewFile()) {
                System.out.println("Fichier des comptes cr�� avec succ�s : " + fichier.getAbsolutePath());
            } else {
                System.out.println("Le fichier des comptes existe d�j� : " + fichier.getAbsolutePath());
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
                
                // Extraire les informations n�cessaires du tableau d'�l�ments
                String nom = elements[2];
                String prenom = elements[3];
                String email = elements[4];
                String adressePostale = elements[5];
                String dateNaissance = elements[6];
                String profil = elements[7];
                String dateAjout = elements[8];
                String dateMaj = elements[9];
                
                // Cr�er un objet Particulier avec les informations extraites
                Personne personne = new Personne(nom, prenom, email, adressePostale, dateNaissance, profil, dateAjout, dateMaj);
                
                // Ajouter le particulier � la liste
                annuaires.add(personne);
            }
	    } catch (FileNotFoundException e) {
	        System.out.println("Le fichier des comptes n'existe pas. Cr�ation du fichier...");
	        creerFichierComptes();
	        //charger(); // Essayez de charger � nouveau apr�s la cr�ation du fichier

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void ajouterParticulier(String email, String motDePasse) {
        chargerAnnuaire(); // Charger l'annuaire depuis le fichier

            // V�rifier si le compte existe d�j�
            if (!compteManager.compteExiste(email)) {
                // Demander les informations sur le particulier
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nom : ");
                String nom = scanner.nextLine();

                System.out.print("Pr�nom : ");
                String prenom = scanner.nextLine();

                System.out.print("Adresse Postale : ");
                String adressePostale = scanner.nextLine();

                System.out.print("Date de Naissance : ");
                String dateNaissance = scanner.nextLine();

                System.out.print("Profil (Auditeurs, Enseignants, Direction) : ");
                String profil = scanner.nextLine();

                // Ajouter le compte
                compteManager.ajouterParticulier(email, motDePasse);
                
                // Cr�er un objet Particulier avec les informations saisies
                Personne particulier = new Personne(nom, prenom, email, adressePostale, dateNaissance, profil, "", "");
                
                // Ajouter le particulier � l'annuaire
                annuaires.add(particulier);

                // Sauvegarder l'annuaire
                sauvegarderAnnuaire();
                System.out.println("Particulier ajout� avec succ�s.");
            } else {
                System.out.println("Echec : Un compte avec cet email existe d�j�.");
            }
          }
    
    public ArrayList<Personne> rechercherParNom(String nom) {
        ArrayList<Personne> resultats = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_ANNUAIRE))) {
            String ligne;

            while ((ligne = reader.readLine()) != null) {
                String[] elements = ligne.split(";");
                Personne particulier = new Personne(elements[0], elements[1], elements[2], elements[3], elements[4], elements[5], elements[6], elements[7]);
                if (particulier.getNom().equalsIgnoreCase(nom)) {
                    resultats.add(particulier);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultats;
    }

    public Personne rechercherParEmail(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_ANNUAIRE))) {
            String ligne;

            while ((ligne = reader.readLine()) != null) {
                String[] elements = ligne.split(";");
                Personne particulier = new Personne(elements[0], elements[1], elements[2], elements[3], elements[4], elements[5], elements[6], elements[7]);

                if (particulier.getEmail().equalsIgnoreCase(email)) {
                    return particulier;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Aucune correspondance trouv�e
    }

    public ArrayList<Personne> rechercherParProfil(String profil) {
        ArrayList<Personne> resultats = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER_ANNUAIRE))) {
            String ligne;

            while ((ligne = reader.readLine()) != null) {
                String[] elements = ligne.split(";");
                Personne particulier = new Personne(elements[0], elements[1], elements[2], elements[3], elements[4], elements[5], elements[6], elements[7]);

                if (particulier.getProfil().equalsIgnoreCase(profil)) {
                    resultats.add(particulier);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultats;
    }

    public void afficherResultatsRecherche(String choix) {
        Scanner scanner = new Scanner(System.in);
        
        switch (choix) {
            case "A": // Recherche par Nom
                System.out.print("Entrez le nom � rechercher : ");
                String nomRecherche = scanner.nextLine();
                ArrayList<Personne> resultatsNom = rechercherParNom(nomRecherche);
                afficherResultats(resultatsNom);
                break;

            case "B": // Recherche par Email
                System.out.print("Entrez l'email � rechercher : ");
                String emailRecherche = scanner.nextLine();
                Personne resultatEmail = rechercherParEmail(emailRecherche);
                afficherResultats(resultatEmail);
                break;

            case "C": // Recherche par Profil
                System.out.print("Entrez le profil � rechercher : ");
                String profilRecherche = scanner.nextLine();
                ArrayList<Personne> resultatsProfil = rechercherParProfil(profilRecherche);
                afficherResultats(resultatsProfil);
                break;

            default:
                System.out.println("Choix invalide.");
                break;
        }
    }

    private void afficherResultats(ArrayList<Personne> resultats) {
        if (resultats.isEmpty()) {
            System.out.println("Aucun r�sultat trouv�.");
        } else {
            System.out.println("R�sultats de la recherche :");
            for (Personne particulier : resultats) {
                System.out.println("Nom : "+particulier.getNom()+" Prenom : "+particulier.getPrenom()+" Email : "+particulier.getEmail()); // Supposant que Particulier a une m�thode toString appropri�e
            }
        }
    }

    private void afficherResultats(Personne resultat) {
        if (resultat == null) {
            System.out.println("Aucun r�sultat trouv�.");
        } else {
            System.out.println("R�sultat de la recherche :");
            System.out.println("Nom : "+resultat.getNom()+" Prenom : "+resultat.getPrenom()+" Email : "+resultat.getEmail()); // Supposant que Particulier a une m�thode toString appropri�e

        }
    }
    
	public ArrayList<Personne> getPersonnes() {
		return annuaires;
	}

	public void setPersonnes(ArrayList<Personne> annuaires) {
		this.annuaires = annuaires;
	}
   
}
