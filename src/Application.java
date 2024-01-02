import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public ArrayList<Compte> listeComptes() throws IOException {

        FileReader filereader = new FileReader("Comptes.txt");
        //FileWriter filewriter = new FileWriter("Comptes.txt", true);
        BufferedReader bufferedreader = new BufferedReader(filereader);
        //BufferedWriter bufferedwriter = new BufferedWriter(filewriter);

        String temporaire = bufferedreader.readLine();
        String chainecomptes = "";
        //temporaire = bufferedreader.readLine();

        while (temporaire != null) {

            chainecomptes = chainecomptes.concat(temporaire);
            chainecomptes = chainecomptes.concat(";");

            temporaire = bufferedreader.readLine();
        }
        System.out.println(chainecomptes);


        String[] tabcomptes = chainecomptes.split(";");

        bufferedreader.close();
        //bufferedwriter.close();
        filereader.close();
        //filewriter.close();

        ArrayList<Compte> listecomptes = new ArrayList<>();

        for (int i = 0; i<tabcomptes.length - 1 ; i = i + 3){
            System.out.println(tabcomptes[i] + tabcomptes[i+1] + tabcomptes[i+2]);


            Compte compte = new Compte(tabcomptes[i], tabcomptes[i+1], tabcomptes[i+2]);

            /*for(int j = i; j < i + 3; j = j + 1 ){

                if(j == i){
                    compte.setEmail(tabcomptes[j]);
                }

                if(j == i + 1){
                    compte.setMotdepasse(tabcomptes[j]);
                }

                if(j == i + 2){
                    compte.setRole(tabcomptes[j]);
                }

            }*/

            listecomptes.add(compte);

        }

        return listecomptes;

    }
    public ArrayList<Annuaire> listeAnnuaire() throws IOException {

        FileReader filereader = new FileReader("Annuaire.txt");
        BufferedReader bufferedreader = new BufferedReader(filereader);
        //rajouter pour toutes les lignes


        String temporaire = bufferedreader.readLine();
        String chaineannuaire = "";

        while (temporaire != null) {

            chaineannuaire = chaineannuaire.concat(temporaire);
            chaineannuaire = chaineannuaire.concat(";");

            temporaire = bufferedreader.readLine();
        }

        String[] tabannuaire = chaineannuaire.split(";");

        bufferedreader.close();
        filereader.close();

        ArrayList<Annuaire> listeannuaire = new ArrayList<>();

        for (int i = 0; i<tabannuaire.length - 1; i = i + 8){

            Annuaire annuaire = new Annuaire(tabannuaire[i], tabannuaire[i+1], tabannuaire[i+2], tabannuaire[i+3], tabannuaire[i+4], tabannuaire[i+5], tabannuaire[i+6], tabannuaire[i+7]);
            /*Annuaire annuaire = new Annuaire();
            Annuaire annuaire = new Annuaire("nom", "prenom", "email", "adressepostale", "datenaissance", "profil", "dateajout", "datemaj");

            for(int j = i; j < i + 8; j = j + 1 ){

                if(j == i){
                    annuaire.setNom(tabannuaire[j]);
                }

                if(j == i + 1){
                    annuaire.setPrenom(tabannuaire[j]);
                }

                if(j == i + 2){
                    annuaire.setEmail(tabannuaire[j]);
                }

                if(j == i + 3){
                    annuaire.setAdressePostale(tabannuaire[j]);
                }

                if(j == i + 4){
                    annuaire.setDateNaissance(tabannuaire[j]);
                }

                if(j == i + 5){
                    annuaire.setProfil(tabannuaire[j]);
                }

                if(j == i + 6){
                    annuaire.setDateAjout(tabannuaire[j]);
                }

                if(j == i + 7){
                    annuaire.setDateMaj(tabannuaire[j]);
                }

            }*/

            listeannuaire.add(annuaire);

        }

        return listeannuaire;

    }
    public void fichierCompte(ArrayList<Compte> listecompte) throws IOException {

        FileWriter fileWriter = new FileWriter("Comptes.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String ligne;

        for(Compte compte : listecompte){

            ligne = "";
            ligne = compte.getEmail();
            ligne = ligne.concat(";");

            ligne = ligne.concat(compte.getMotdepasse());
            ligne = ligne.concat(";");

            ligne = ligne.concat(compte.getRole());

            bufferedWriter.write(ligne);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

        bufferedWriter.close();
        fileWriter.close();
    }
    public void fichierAnnuaire(ArrayList<Annuaire> listeannuaire) throws IOException {

        FileWriter fileWriter = new FileWriter("Annuaire.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String ligne;

        for(Annuaire annuaire : listeannuaire){

            ligne = "";
            ligne = annuaire.getNom();
            ligne = ligne.concat(";");

            ligne = ligne.concat(annuaire.getPrenom());
            ligne = ligne.concat(";");

            ligne = ligne.concat(annuaire.getEmail());
            ligne = ligne.concat(";");

            ligne = ligne.concat(annuaire.getAdressePostale());
            ligne = ligne.concat(";");

            ligne = ligne.concat(annuaire.getDateNaissance());
            ligne = ligne.concat(";");

            ligne = ligne.concat(annuaire.getProfil());
            ligne = ligne.concat(";");

            ligne = ligne.concat(annuaire.getDateAjout());
            ligne = ligne.concat(";");

            ligne = ligne.concat(annuaire.getDateMaj());

            bufferedWriter.write(ligne);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();

        bufferedWriter.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {

        try {


            Application application = new Application();
            Datejour datejour = new Datejour();
            //File comptes = new File("Comptes.txt");
            //System.out.println(application.listeComptes());

            ArrayList<Compte> listecomptes = application.listeComptes();
            ArrayList<Annuaire> listeannuaire = application.listeAnnuaire();

            String reiterer = "1";

            for (Compte comptetest : listecomptes) {
                System.out.println(comptetest.getEmail() + "1\n" + comptetest.getMotdepasse() + "2\n" + comptetest.getRole() + "3\n");
            }

            while (reiterer.equals("1")) {

                System.out.println("            Bienvenue dans l’Annuaire NFA032\n" +
                        "\n" +
                        "Administrateur :\n" +
                        " 1. Ajouter une personne\n" +
                        "   A. Ajouter un Admin\n" +
                        "   B. Ajouter un particulier\n" +
                        "Particulier :\n" +
                        " 2. Rechercher un ou des particuliers\n" +
                        "   A. Par nom\n" +
                        "   B. Par email\n" +
                        "   C. Par profil\n" +
                        "3. Modifier mes informations personnelles\n" +
                        "\n" +
                        "Faites votre choix : ___\n");

                //try {
                //ArrayList<Compte> listecomptes = application.listeComptes();
                Scanner scanner = new Scanner(System.in);

                String verification = scanner.nextLine();

                boolean trouve = false;
                boolean erreur = false;


                switch (verification) {

                    case "1":

                        do {

                            System.out.println("Saisissez votre email :");
                            String email = scanner.nextLine();
                            System.out.println("Saisissez votre mot de passe :");
                            String motdepasse = scanner.nextLine();

                            Compte nouveaucompte = new Compte();
                            Annuaire nouvelannuaire = new Annuaire();
                            //Annuaire nouvelannuaire = new Annuaire("nom", "prenom", "email", "adressepostale", "datenaissance", "profil", "dateajout", "datemaj");

                            boolean trouve2 = false;

                            for (Compte compte : listecomptes) {

                                if (compte.getEmail().equals(email)) {

                                    if (compte.getMotdepasse().equals(motdepasse)) {

                                        trouve = true;

                                        if (compte.getRole().equals("admin")) {

                                            do {


                                                System.out.println("A. Ajouter un Admin\n" +
                                                        "B. Ajouter un particulier\n" +
                                                        "\n" +
                                                        "Faites votre choix :");

                                                verification = scanner.nextLine();


                                                switch (verification) {

                                                    case "A":

                                                        erreur = false;

                                                        System.out.println("Saisir l'adresse email du nouvel administrateur :");

                                                        email = scanner.nextLine();

                                                        for (Compte compte1 : listecomptes) {

                                                            if (compte1.getEmail().equals(email)) {

                                                                trouve2 = true;
                                                                System.out.println("Il existe déjà un administrateur possédant cet email.");
                                                            }
                                                        }
                                                        if (!trouve2) {

                                                            nouveaucompte.setEmail(email);
                                                            nouveaucompte.setRole("admin");

                                                            System.out.println("Saisir le mot de passe du nouvel administrateur :");
                                                            String entree = scanner.nextLine();
                                                            nouveaucompte.setMotdepasse(motdepasse);


                                                            System.out.println("Saisir le nom de l'administrateur pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setNom(entree);

                                                            System.out.println("Saisir le prenom de l'administrateur pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setPrenom(entree);

                                                            nouvelannuaire.setEmail(email);

                                                            System.out.println("Saisir l'adresse postale de l'administrateur pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setAdressePostale(entree);

                                                            System.out.println("Saisir la date de naissance de l'administrateur pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setDateNaissance(entree);

                                                            System.out.println("Saisir le profil de l'administrateur pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setProfil(entree);


                                                            nouvelannuaire.setDateAjout(datejour.getDateTime());
                                                            nouvelannuaire.setDateMaj(datejour.getDateTime());

                                                        }
                                                        break;

                                                    case "B":

                                                        erreur = false;

                                                        System.out.println("Saisir l'adresse email du nouveau particulier :");

                                                        email = scanner.nextLine();

                                                        for (Compte compte1 : listecomptes) {

                                                            if (compte1.getEmail().equals(email)) {

                                                                trouve2 = true;
                                                                System.out.println("Il existe déjà un particulier possédant cet email.");
                                                            }
                                                        }
                                                        if (!trouve2) {

                                                            nouveaucompte.setEmail(email);
                                                            nouveaucompte.setRole("user");

                                                            System.out.println("Saisir le mot de passe du nouveau particulier :");
                                                            String entree = scanner.nextLine();
                                                            nouveaucompte.setMotdepasse(motdepasse);

                                                            System.out.println("Saisir le nom du particulier pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setNom(entree);

                                                            System.out.println("Saisir le prenom du particulier pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setPrenom(entree);

                                                            nouvelannuaire.setEmail(email);

                                                            System.out.println("Saisir l'adresse postale du particulier pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setAdressePostale(entree);

                                                            System.out.println("Saisir la date de naissance du particulier pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setDateNaissance(entree);

                                                            System.out.println("Saisir le profil du particulier pour l'annuaire :");
                                                            entree = scanner.nextLine();
                                                            nouvelannuaire.setProfil(entree);


                                                            nouvelannuaire.setDateAjout(datejour.getDateTime());
                                                            nouvelannuaire.setDateMaj(datejour.getDateTime());

                                                        }
                                                        break;

                                                    default:

                                                        erreur = true;
                                                        System.out.println("Votre saisie est incorrecte.");

                                                        break;

                                                }
                                            } while (erreur);
                                        } else {
                                            System.out.println("Vous n'êtes pas un administrateur.");
                                        }

                                    }
                                }
                            }
                            if (!trouve2) {

                                listecomptes.add(nouveaucompte);
                                listeannuaire.add(nouvelannuaire);
                            }
                        } while (!trouve);

                        break;


                    case "2":

                        Annuaire annuaire = new Annuaire();
                        //Annuaire annuaire = new Annuaire("nom","prenom","email","adressepostale","datenaissance","profil","dateajout","datmaj");

                        int compteur = 0;
                        int i = listeannuaire.size();

                        do {

                            System.out.println("    Recherche :\n" +
                                    " A. Par nom\n" +
                                    " B. Par email\n" +
                                    " C. Par profil\n" +
                                    "Faites votre choix : ");
                            verification = scanner.nextLine();

                            switch (verification) {

                                case "A":

                                    erreur = false;

                                    System.out.println("Saisir un nom à rechercher :");
                                    String nom = scanner.nextLine();

                                    System.out.print("Les entrées de l'annuaire correspondantes ");

                                    while (i > 0 && compteur < 10) {

                                        i = i - 1;

                                        annuaire = listeannuaire.get(i);

                                        if (annuaire.getNom().equals(nom)) {

                                            trouve = true;

                                            compteur = compteur + 1;

                                            System.out.println("\n" +
                                                    " Nom : " + annuaire.getNom() + "\n" +
                                                    " Prenom : " + annuaire.getPrenom() + "\n" +
                                                    " Email : " + annuaire.getEmail() + "\n" +
                                                    " Adresse postale : " + annuaire.getAdressePostale() + "\n" +
                                                    " Date de naissance : " + annuaire.getDateNaissance() + "\n" +
                                                    " Profil : " + annuaire.getProfil() + "\n" +
                                                    " Ajouté le " + annuaire.getDateAjout() + "\n" +
                                                    " Modifié pour la dernière fois le " + annuaire.getDateMaj());
                                        }


                                    }
                                    if (!trouve) {
                                        System.out.println("n'éxistent pas.");
                                    }

                                    break;

                                case "B":

                                    erreur = false;

                                    System.out.println("Saisir un email à rechercher :");
                                    String email = scanner.nextLine();

                                    for (Annuaire iterationannuaire : listeannuaire) {

                                        if (iterationannuaire.getEmail().equals(email)) {

                                            System.out.println("L'entrée de l'annuaire correspondante contient :\n" +
                                                    " Nom : " + iterationannuaire.getNom() + "\n" +
                                                    " Prenom : " + iterationannuaire.getPrenom() + "\n" +
                                                    " Email : " + iterationannuaire.getEmail() + "\n" +
                                                    " Adresse postale : " + iterationannuaire.getAdressePostale() + "\n" +
                                                    " Date de naissance : " + iterationannuaire.getDateNaissance() + "\n" +
                                                    " Profil : " + iterationannuaire.getProfil() + "\n" +
                                                    " Ajouté le " + iterationannuaire.getDateAjout() + "\n" +
                                                    " Modifié pour la dernière fois le " + iterationannuaire.getDateMaj());
                                        } else {
                                            System.out.println("Il n'éxiste pas d'entrée correpondante dans l'annuaire.");
                                        }
                                    }

                                    break;

                                case "C":

                                    erreur = false;

                                    System.out.println("Saisir un profil à rechercher :");
                                    String profil = scanner.nextLine();
                                    System.out.print("Les entrées de l'annuaire correspondantes ");


                                    while (i > 0 && compteur < 10) {

                                        i = i - 1;

                                        annuaire = listeannuaire.get(i);

                                        if (annuaire.getProfil().equals(profil)) {

                                            trouve = true;

                                            compteur = compteur + 1;

                                            System.out.println("\n" +
                                                    " Nom : " + annuaire.getNom() + "\n" +
                                                    " Prenom : " + annuaire.getPrenom() + "\n" +
                                                    " Email : " + annuaire.getEmail() + "\n" +
                                                    " Adresse postale : " + annuaire.getAdressePostale() + "\n" +
                                                    " Date de naissance : " + annuaire.getDateNaissance() + "\n" +
                                                    " Profil : " + annuaire.getProfil() + "\n" +
                                                    " Ajouté le " + annuaire.getDateAjout() + "\n" +
                                                    " Modifié pour la dernière fois le " + annuaire.getDateMaj());
                                        }

                                    }
                                    if (!trouve) {
                                        System.out.println("n'éxistent pas.");
                                    }

                                    break;

                                default:

                                    erreur = true;

                                    System.out.println("Votre saisie est incorrecte.");

                                    break;
                            }
                        } while (erreur);

                        break;

                    case "3":

                        do {

                            System.out.println("Saisissez votre email :");
                            String email = scanner.nextLine();
                            System.out.println("Saisissez votre mot de passe :");
                            String motdepasse = scanner.nextLine();

                            for (Compte compte : listecomptes) {

                                if (compte.getEmail().equals(email)) {

                                    if (compte.getMotdepasse().equals(motdepasse)) {

                                        trouve = true;

                                        if (compte.getRole().equals("admin")) {

                                            String reiterer1;

                                            do {

                                                System.out.println("Saisir l'email du particulier à modifier : ");
                                                email = scanner.nextLine();

                                                erreur = true;

                                                for (Annuaire annuaire1 : listeannuaire) {

                                                    if (annuaire1.getEmail().equals(email)) {

                                                        erreur = false;

                                                        System.out.println("Modifiez le nom : ");
                                                        String nom = scanner.nextLine();
                                                        annuaire1.setNom(nom);

                                                        System.out.println("Modifiez le prenom : ");
                                                        String prenom = scanner.nextLine();
                                                        annuaire1.setPrenom(prenom);

                                                        for (Compte compte1 : listecomptes) {

                                                            if (compte1.getEmail().equals(annuaire1.getEmail())) {

                                                                System.out.println("Modifiez l'email : ");
                                                                email = scanner.nextLine();
                                                                compte1.setEmail(email);
                                                                annuaire1.setEmail(email);
                                                            }
                                                        }

                                                        System.out.println("Modifiez l'adresse postale : ");
                                                        String adressepostale = scanner.nextLine();
                                                        annuaire1.setAdressePostale(adressepostale);

                                                        System.out.println("Modifiez la date de naissance : ");
                                                        String datenaissance = scanner.nextLine();
                                                        annuaire1.setDateNaissance(datenaissance);

                                                        System.out.println("Modifiez le profil : ");
                                                        String profil = scanner.nextLine();
                                                        annuaire1.setProfil(profil);

                                                        annuaire1.setDateMaj(datejour.getDateTime());

                                                    }
                                                }
                                                if (erreur) {
                                                    System.out.println("Il n'existe pas de particulier possédant cet email.");
                                                }
                                                System.out.println("Voulez vous modifiez à nouveau un particulier ?\n" +
                                                        "   1. Oui\n" +
                                                        "   2. Non\n" +
                                                        "Faites votre choix : ");

                                                reiterer1 = scanner.nextLine();

                                            } while (reiterer1.equals("1"));

                                        } else {

                                            for (Annuaire annuaire1 : listeannuaire) {

                                                if (annuaire1.getEmail().equals(email)) {

                                                    System.out.println("Modifiez votre nom : ");
                                                    String nom = scanner.nextLine();
                                                    annuaire1.setNom(nom);

                                                    System.out.println("Modifiez votre prenom : ");
                                                    String prenom = scanner.nextLine();
                                                    annuaire1.setPrenom(prenom);

                                                    for (Compte compte1 : listecomptes) {

                                                        if (compte1.getEmail().equals(annuaire1.getEmail())) {

                                                            System.out.println("Modifiez votre email : ");
                                                            email = scanner.nextLine();
                                                            compte1.setEmail(email);
                                                            annuaire1.setEmail(email);
                                                        }
                                                    }

                                                    System.out.println("Modifiez votre adresse postale : ");
                                                    String adressepostale = scanner.nextLine();
                                                    annuaire1.setAdressePostale(adressepostale);

                                                    System.out.println("Modifiez votre date de naissance : ");
                                                    String datenaissance = scanner.nextLine();
                                                    annuaire1.setDateNaissance(datenaissance);

                                                    System.out.println("Modifiez votre profil : ");
                                                    String profil = scanner.nextLine();
                                                    annuaire1.setProfil(profil);

                                                    annuaire1.setDateMaj(datejour.getDateTime());

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } while (!trouve);

                        break;

                    default:

                        System.out.println("Votre saisie est incorrecte.");

                        break;
                }

                System.out.println("Voulez vous recommencer ?\n" +
                        "   1. Oui\n" +
                        "   2. Non\n" +
                        "Faites votre choix : ");

                reiterer = scanner.nextLine();
            }
            application.fichierCompte(listecomptes);
            application.fichierAnnuaire(listeannuaire);
        }

        catch(FileNotFoundException exc){
            System.out.println("Vous devez placer les fichiers Comptes.txt et Annuaire.txt à cet endroit : " + System.getProperty("user.dir"));
        }

    }
}
