import java.util.Scanner;

public class MenuPrincipal {
	
	private CompteManager compteManager;
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
       System.out.println("Add");
       
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
       
       annuaire.getPersonnes().add(new Personne(nom, prenom, email, adresse, dateNaissance, null, null, null));
       annuaire.sauvegarderAnnuaire("AnnuaireNFA.txt");
       System.out.println("Fichier Créer");
    }

    private static void rechercherPersonne(Scanner scanner) {
        // Ajoutez le code pour gérer la recherche de particuliers
        System.out.println("Fonctionnalité non implémentée.");
    }

    private static void modifierInformationsPersonnelles(Scanner scanner) {
        // Ajoutez le code pour gérer la modification des informations personnelles
        System.out.println("Fonctionnalité non implémentée.");
    }
   
}
