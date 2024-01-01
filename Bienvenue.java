package projetcommun;

import java.util.Scanner;

public class Bienvenue {
	
	private static Object administrateur, particulier;
	public String login; 
	public String mdp;
	public static Object logintype;
	
	String getLogin() {
		return login;
	}
	
	String getmdp() {
		return mdp;
	}
	
	public static void main(String[]args) {
	System.out.println("Veuillez vous authentifier en renseignant votre login et mot de passe"); 
	Scanner scanner1 = new Scanner(System.in); 
	Scanner scanner2 = new Scanner(System.in); 
	
	if ((boolean) (logintype = administrateur != null)) {
		System.out.println("Indiquez l'action souhaitée: "
				+ "1.Ajouter une personne"
				+ "2. Rechercher un ou des particuliers"
				+ "3. Modifier mes informations personnelles");
		Scanner scanner3 = new Scanner(System.in); } 
		
		else if ((boolean) (logintype = particulier != null)) {
			System.out.println("Indiquez l'action souhaitée: "
				+ "2. Rechercher un ou des particuliers"
				+ "3. Modifier mes informations personnelles");
			Scanner scanner4 = new Scanner(System.in); }
		
		else {
			System.out.println("contacter un administrateur pour vous créer un compte");
		}
		
	}
	
	
	

}
