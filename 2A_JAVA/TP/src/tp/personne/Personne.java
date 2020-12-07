package tp.personne;

import java.util.Scanner;

public class Personne {

	private DateDeNaissance DateDeNaissance;
	private String Nom;
	
	public Personne(String Mois, int Jour, int Annee, String Nom) {
		this.DateDeNaissance = new DateDeNaissance(Mois, Jour, Annee);
		this.Nom = Nom;
	}

	public String Age(){
		return(this.DateDeNaissance.Age());
	}
	
	public String toSrting() {
		return(this.Nom + " né le " + this.DateDeNaissance.toString()  + " : " + this.DateDeNaissance.Age());
	}
	
	public void TestRun() {
		Personne Je = new Personne("mai", 28, 2001, "Zacharie");
		Personne Tu = new Personne("decembre", 21 , 2005, "JulienC");
		Personne Il = new Personne("octobre", 7, 2020, "Le Vieux Monsieur");
		Personne Nous = new Personne("novembre", 9, 2020, "Ken Bogard");
		Personne Vous = new Personne("avril", 1, 2021, "Mr Quaraté");
		Personne Ils = new Personne("novembre", 10, 2020, "Trunks");
		Personne[] People = {Je, Tu, Il, Nous, Vous, Ils};
		
		System.out.println("Personnes enregistrées :");
		for (Personne i : People) {
			System.out.println(i.toSrting());
		}
		
		Scanner ScanReponse = new Scanner(System.in);
		System.out.println("Voulez-vous vous enrgistrer ? Y/N");
		String Reponse = ScanReponse.nextLine();
		System.out.println(Reponse);

		if (Reponse.equals("y") || Reponse.equals("Y")) {
			ScanReponse.close();
			
			Scanner ScanNom = new Scanner(System.in);
		
			System.out.println("Entrez votre nom");
			String Nom = ScanNom.nextLine();
		
			System.out.println("Entrez votre mois de naissance (minuscule sans accents)");
			String MoisNaissance = ScanNom.nextLine();
		
			System.out.println("Entrez votre jour de naissance");
			int JourNaissance = ScanNom.nextInt();
		
			System.out.println("Entrez votre année de naissance");
			int AnneeNaissance = ScanNom.nextInt();
		
			Personne Lui = new Personne(MoisNaissance, JourNaissance, AnneeNaissance, Nom);
			System.out.println("Vous êtes : " + Lui.toSrting());

			ScanNom.close();
		}
		else {
			System.out.println("Bonne journée");
		}
	}
	
	
}
