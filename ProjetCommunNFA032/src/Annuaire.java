import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Annuaire {

	private ArrayList<Personne> personnes;
	
    public Annuaire() {
        this.personnes = new ArrayList<>();
    }

    public void sauvegarderAnnuaire(String fichier) {
    	
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            for (Personne personne : personnes) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chargerAnnuaire(String fichier) {
        personnes.clear(); 

        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(";");
                String nom = parts[0];
                String prenom = parts[1];
                String email = parts[2];
                String adressePostale = parts[3];
                String dateNaissance = parts[4];
                String profil = parts[5];
                String dateAjout = parts[6];
                String dateMaj = parts[7];

                personnes.add(new Personne(nom, prenom, email, adressePostale, dateNaissance, profil, dateAjout, dateMaj));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public ArrayList<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(ArrayList<Personne> personnes) {
		this.personnes = personnes;
	}
   
}
