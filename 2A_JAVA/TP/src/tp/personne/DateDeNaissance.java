package tp.personne;
import java.util.Arrays;

public class DateDeNaissance {
	
	private int AnneeNaissance;
	private String MoisNaissance;
	private int JourNaissance;
    
    public DateDeNaissance(String Mois, int Jour, int Annee) {
		this.AnneeNaissance = Annee;
		this.MoisNaissance = Mois;
		this.JourNaissance = Jour;
	}

	public String Age() {
		// Rend l'age à compter du 10 novembre 2020. La longueur des mois est approximée à 30 jours (moyenne réèlle = 30.4375).
		String[] ListeMois = {"janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"};
		int MoisNb = Arrays.asList(ListeMois).indexOf(this.MoisNaissance)+1;
		int Annee = this.AnneeNaissance;
		int Jour = this.JourNaissance;
		
		if (Annee >= 2020) { 
			if (Annee > 2020) {
				return("pas encore né");
			}
			else if (MoisNb >= 11) {
				if (MoisNb > 11) {
					return ("pas encore né");
				}
				else if (Jour > 10) {
					return ("pas encore né");
				}
			}
		}
		int AgeJours = 30 - Jour + 10;
		int AgeAnnee = 2020 - Annee;
		if (MoisNb > 11) {
			AgeAnnee -= 1;
			int AgeMois = 12 - (MoisNb - 11) - 1;
			if (AgeJours < 30) {
				return(AgeAnnee+" ans , "+AgeMois+" mois , "+ AgeJours+" jours");
			}
			else if (AgeJours >= 30) {
				AgeMois = AgeMois + 1;
				AgeJours -= 30;
				return(AgeAnnee+" ans , "+AgeMois+" mois , "+ AgeJours+" jours");
			}
		}
		else if (MoisNb < 11) {
			int AgeMois = 11 - MoisNb - 1;
			if (AgeJours < 30) {
				return(AgeAnnee+" ans , "+AgeMois+" mois , "+ AgeJours+" jours");
			}
			else if (AgeJours >= 30) {
				AgeMois += 1;
				AgeJours -= 30;
				return(AgeAnnee+" ans , "+AgeMois+" mois , "+ AgeJours+" jours");
			}
		}
		else {
			if (Jour == 10) {
				return("né aujourd'hui, mardi 10 novembre 2020");
			}
			else {
				AgeJours = 10 - Jour;
				return(AgeJours + " jours");
			}
		}
		return("chier");
	}
	
    public int getAnnee() {
	    return(this.AnneeNaissance);
    }

	public String toString() {
		return(this.JourNaissance + " " + this.MoisNaissance + " " + this.AnneeNaissance);
	}
	
	
}