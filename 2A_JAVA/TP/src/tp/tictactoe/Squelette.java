
package tp.tictactoe;

import java.util.Scanner;

public class Squelette {

    private int[][] grille;
    private int Taille;
	
	public Squelette() {
        this.grille = new int[3][3];
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				this.grille[i][j]=0;
			}
        }
        this.Taille = 3;
	}
	
	public String toString() {
		String str="";
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				str=str+" "+grille[i][j];
			}
			str=str+"\n";
		}
		return str;
	}
	
	private void tourDeJeu(int joueur) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tour du joueur "+joueur+":");
		//On demande une premiÃ¨re entrée.
		System.out.println("Numéro de ligne?");
		String str = sc.nextLine();
		int i = Integer.parseInt(str);
		//On demande une autre entrée.
		System.out.println("Numéro de colonne?");
		str = sc.nextLine();
		int j = Integer.parseInt(str);
        //On met la grille à  jour en conséquence.
        if (i >= 0 && j >= 0 && i < this.Taille && j < this.Taille) {
            if (joueur == 1) grille[i][j]=1;
		    else {
			    grille[i][j]=-1;
            }
        }
        else tourDeJeu(joueur);
	}
	
	private int sommeLigne(int i) {
		int somme=0;
		for (int j=0;j<3;j++) {
			somme+=grille[i][j];
		}
		return somme;
	}
	
	private int sommeColonne(int j) {
		int somme=0;
		for (int i=0;i<3;i++) {
			somme+=grille[i][j];
		}
		return somme;
	}
	
	private int sommeDiag1() {
		int somme=0;
		for (int i=0;i<3;i++) {
			somme+=grille[i][i];
		}
		return somme;
	}
	
	private int sommeDiag2() {
		int somme=0;
		for (int i=0;i<3;i++) {
			somme+=grille[i][2-i];
		}
		return somme;
	}
	
	private int etatPartie() {
		//On teste les lignes.
		for (int i=0;i<3;i++) {
			int sommeLigne=sommeLigne(i);
			if (sommeLigne==3) return 1;
			else if (sommeLigne==-3) return -1;
		}
		//On teste les colonnes.
		for (int j=0;j<3;j++) {
			int sommeColonne=sommeColonne(j);
			if (sommeColonne==3) return 1;
			else if (sommeColonne==-3) return -1;
		}
		//On teste les diagonales.
		if (sommeDiag1()==3 || sommeDiag2()==3) return 1;
		else if (sommeDiag1()==-3 || sommeDiag2()==-3) return -1;
		//Personne n'a gagné.
		return 0;
	}
	
	public void jouerUnePartie() {
		int etatPartie=0;
		int nbTours=0;
		int joueur=1;
		while(etatPartie==0 && nbTours<(this.Taille*this.Taille)) {
			tourDeJeu(joueur);
			etatPartie=etatPartie();
			nbTours++;
			if (joueur==1) joueur=2;
			else joueur=1;
			System.out.println(this.toString());
		}
		if (etatPartie==0) System.out.println("Match nul");
		else if (etatPartie==1) System.out.println("Victoire joueur 1");
		else System.out.println("Victoire joueur 2");
	}
}
