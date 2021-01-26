package tp_jdr.Plateau;

import java.util.Scanner;

public class CoffreAuTresor extends EvenementAmicale {
	
	public void CoffreAuTresor() {
		this.Contenu = "Vous tombez sur un coffre au trésor sertit de diamant qui pourrait contenir un trésor d'une valeur inestimable!!! Mais il vous faut faire un choix, voulez vous l'ouvrir au risque de tomber sur un mimic ou préferez vous laisser le contenu de ce coffre tranquille?(oui/non)";
		Scanner Coffre = new Scanner(System.in);
		String Rep = Coffre.nextLine();
		switch(Rep) {
			case "oui":
				int cas;
				cas = (int)(Math.random() * 4);
				switch(cas) {
					case 0:
						System.out.println("Vous obtenez l'�quipement complet de l'�cole du griffon pour votre sorceleur, son armure augmente de 5 points!");
						break;
					case 1:
						System.out.println("Vous obtenez une huile sp�ciale qui ravive les flammes purificatrices de la lamme de l'inquisiteur, c'est d�gats de feu augmente de 3!");
						break;
					case 2:
						System.out.println("Vous obtenez une masse d'arme naine de haute qualit�, votre nain augmante ses d�gats de 5!");
						break;
					case 3:
						System.out.println("Vous obtenez un parchemin de magie noire qui augmente la magie de foudre de votre magicienne de 3!");
						break;
					case 4:
						System.out.println("Le coffre contenait en fait un elfe des chataignes qui virevolte autour de votre �quipe restaurant 50 points de vie � chaque membre!");
						break;
					default:
						System.out.println("Le coffre est vide dommage.");
						break;
				}
				break;
			case "non":
				System.out.println("Vous decidez de continuez votre chemin sans ouvrir le coffre. Un choix peu avis� car il contenait de l'�quipement de haute qualit�. Dommage.");
				break;
			default:
				System.out.println("Il faut choisir oui ou non");
				this.CoffreAuTresor();
		}
		
	}
}
