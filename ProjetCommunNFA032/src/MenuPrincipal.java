import java.time.LocalDate;
import java.util.Scanner;

public class MenuPrincipal {
	
	private static CompteManager compteManager = new CompteManager();
	private static Annuaire annuaire = new Annuaire();

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

            int choix;
            do {
                afficherMenu();
                System.out.print("Faites votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine(); 

                switch (choix) {
                    case 1:
                        // Authentification
                        System.out.print("Email : ");
                        String email = scanner.nextLine();

                        System.out.print("Mot de passe : ");
                        String motDePasse = scanner.nextLine();

                        if (compteManager.authentifier(email, motDePasse)) {
                            // L'utilisateur est authentifié
                        } else {
                            System.out.println("Echec de l'authentification. Vérifiez vos informations.");
                        }
                        // Vérification des droits d'accès
                        if (!compteManager.isAdmin(email)) {
                            System.out.println("Vous n'avez pas les droits d'ajouter un particulier.");
                            return;
                        }
                        ajouterPersonne(scanner);
                        break;
                    case 2:
                        rechercherPersonne(scanner);
                        break;
                    case 3:
                        // Authentification
                        System.out.print("Email : ");
                        String email1 = scanner.nextLine();

                        System.out.print("Mot de passe : ");
                        String motDePasse1 = scanner.nextLine();

                        if (compteManager.authentifier(email1, motDePasse1)) {
                            // L'utilisateur est authentifié
                        } else {
                            System.out.println("Echec de l'authentification. Vérifiez vos informations.");
                        }
                        // Vérification des droits d'accès
                        if (!compteManager.isAdmin(email1)) {
                        	annuaire.modifierParticulier(email1);
                        	break;
                        }
                        annuaire.modifierParticulier();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }

            } while (choix != 0);

            scanner.close();

	}
	
    private static void afficherMenu() {
        System.out.println("Bienvenue dans l’Annuaire NFA032");
        System.out.println("Administrateur :");
        System.out.println(" 1. Ajouter une personne");
        System.out.println("   A. Ajouter un Admin");
        System.out.println("   B. Ajouter un particulier");
        System.out.println("Particulier :");
        System.out.println(" 2. Rechercher un ou des particuliers");
        System.out.println("   A. Par nom");
        System.out.println("   B. Par email");
        System.out.println("   C. Par profil");
        System.out.println(" 3. Modifier mes informations personnelles");
        System.out.println("0. Quitter");
    }

    private static void ajouterPersonne(Scanner scanner) {
       
       System.out.println("Veuillez saisir le nom : ");
       String nom = scanner.nextLine();
       
       System.out.println("Veuillez saisir le prénom : ");
       String prenom = scanner.nextLine();
       
       System.out.println("Veuillez saisir l'email : ");
       String email = scanner.nextLine();
       
       System.out.println("Veuillez saisir adresse postale : ");
       String adresse = scanner.nextLine();
       
       System.out.println("Veuillez saisir la date de naissance : ");
       String dateNaissance = scanner.nextLine();
       
       System.out.print("Profil (Auditeurs, Enseignants, Direction) : ");
       String profil = scanner.nextLine();
       
       LocalDate date = LocalDate.now();

       System.out.println("   A. Ajouter un Admin");
       System.out.println("   B. Ajouter un particulier");

       String choix =  scanner.nextLine();
       //scanner.nextLine();
       if(choix.equals("A")) {
    	    annuaire.chargerAnnuaire();
	        // Vérifier si le compte existe déjà
	        if (!compteManager.compteExiste(email)) {
	            System.out.println("Veuillez saisir un mot de passe : ");
	            String mdp = scanner.nextLine();
	     	    compteManager.ajouterAdministrateur(email, mdp);
	            annuaire.getPersonnes().add(new Personne(nom, prenom, email, adresse, dateNaissance, profil, date.toString(), date.toString()));
	            //annuaire.sauvegarderAnnuaire();
	            System.out.println("Fichier Créer");  
	        } else {
	            System.out.println("Echec : Un compte avec cet email existe déjà.");
	        }
       }
       if(choix.equals("B")) {
    	    annuaire.chargerAnnuaire();
	        // Vérifier si le compte existe déjà
	        if (!compteManager.compteExiste(email)) {
	            System.out.println("Veuillez saisir un mot de passe : ");
	            String mdp = scanner.nextLine();
	     	    compteManager.ajouterParticulier(email, mdp);
	            annuaire.getPersonnes().add(new Personne(nom, prenom, email, adresse, dateNaissance, profil, date.toString(), date.toString()));
	            annuaire.sauvegarderAnnuaire();
	            System.out.println("Fichier Créer");  
	        } else {
	            System.out.println("Echec : Un compte avec cet email existe déjà.");
	        }
      }
    }

    private static void rechercherPersonne(Scanner scanner) {
    	System.out.println("Choisir le champ de recherche : ");
        System.out.println("   A. Par nom");
        System.out.println("   B. Par amail");
        System.out.println("   C. Par profil");

        String choix =  scanner.nextLine();
        //scanner.nextLine();
        
        annuaire.afficherResultatsRecherche(choix);

    }
   
}
