import java.util.Scanner;

public class MenuPrincipal {
	
	private static CompteManager compteManager = new CompteManager();
	private static Annuaire annuaire = new Annuaire();

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email : ");
        String email = scanner.nextLine();

        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        // Authentification
        if (compteManager.authentifier(email, motDePasse)) {
            // L'utilisateur est authentifié
            int choix;

            do {
                afficherMenu();
                System.out.print("Faites votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine(); 

                switch (choix) {
                    case 1:
                        ajouterPersonne(scanner);
                        break;
                    case 2:
                        rechercherPersonne(scanner);
                        break;
                    case 3:
                        modifierInformationsPersonnelles(scanner);
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }

            } while (choix != 0);

            scanner.close();

        } else {
            System.out.println("Echec de l'authentification. Vérifiez vos informations.");
        }

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
       
       System.out.println("   A. Ajouter un Admin");
       System.out.println("   B. Ajouter un particulier");

       String choix =  scanner.nextLine();
       scanner.nextLine();
       if(choix.equals("A")) {
	        // Vérifier si le compte existe déjà
	        if (!compteManager.compteExiste(email)) {
	            System.out.println("Veuillez saisir un mot de passe : ");
	            String mdp = scanner.nextLine();
	     	    compteManager.ajouterAdministrateur(email, mdp);
	            annuaire.getPersonnes().add(new Personne(nom, prenom, email, adresse, dateNaissance, null, null, null));
	            annuaire.sauvegarderAnnuaire();
	            System.out.println("Fichier Créer");  
	        } else {
	            System.out.println("Echec : Un compte avec cet email existe déjà.");
	        }
       }
       if(choix.equals("B")) {
	        // Vérifier si le compte existe déjà
	        if (!compteManager.compteExiste(email)) {
	            System.out.println("Veuillez saisir un mot de passe : ");
	            String mdp = scanner.nextLine();
	     	    compteManager.ajouterParticulier(email, mdp);
	            annuaire.getPersonnes().add(new Personne(nom, prenom, email, adresse, dateNaissance, null, null, null));
	            annuaire.sauvegarderAnnuaire();
	            System.out.println("Fichier Créer");  
	        } else {
	            System.out.println("Echec : Un compte avec cet email existe déjà.");
	        }
      }
    }

    private static void rechercherPersonne(Scanner scanner) {

    }

    private static void modifierInformationsPersonnelles(Scanner scanner) {

    }
   
}
