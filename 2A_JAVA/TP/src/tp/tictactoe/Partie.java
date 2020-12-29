
package tp.tictactoe; // Faite pas gaffe

import java.util.Scanner;
import java.io.IOException;

public class Partie {
    
    int[][] PlateauInt;
    int Size;
    int Mode; // 0=JvsJ 1=JvsIA

    // Constructeur par défaut
    public Partie() {
        this.PlateauInt = new int[3][3];
        this.Size = 3;
        System.out.println("Le plateau fait 3x3");
    }

    // Constructeur permettant de créer un plateau plus grand que 3x3 et plus petit que 10x10
    public Partie(int Size) {
        if (Size < 3) {
            this.PlateauInt = new int[3][3];
            this.Size = 3;
            System.out.println("Taille entrée trop petite, le plateau fait 3x3");
        }
        else if (Size <= 10) {
            this.PlateauInt = new int[Size][Size];
            this.Size = Size;
            System.out.println("Le plateau fait " + Size  + "x" + Size + ".");
        }
        else {
            this.PlateauInt = new int[10][10];
            this.Size = 10;
            System.out.println("Taille entrée trop grande, le plateau fait 3x3");
        }
        
    }

    public String toString() {
        
        String ReturnString = " ";
        for (int i=0; i<this.Size; i++) {
            ReturnString += "   " + i;
        }
        ReturnString += "\n";
        
        int i = 0;
        for (int[] Ligne: this.PlateauInt) {
            ReturnString += i + " ";
            i ++;
            for (int j: Ligne) {
                String Sym;
                switch (j) {
                    case 1: Sym = "X";
                        break;
                    case -1: Sym = "O";
                        break;
                    default: Sym = "-";
                }
                ReturnString += String.format("|%2s", Sym) + String.format("%1s", ""); // alternative  ->  ReturnString += j + " ";
            }
            ReturnString += "|" + "\n";
        }
        return(ReturnString);
    }

    public void TourDeJeu(int Joueur) {
        if (this.Mode == 1 && Joueur == -1) {
            int depth = 0;
            for (int[] Ligne: this.PlateauInt) {
                for (int Case: Ligne) {
                    if (Case == 0) {
                        depth += 1;
                    }
                }
            }
            System.out.println(depth);
            int[] BestMove = TourIA(depth, Joueur);
            this.PlateauInt[BestMove[0]][BestMove[1]] = Joueur;
        }
        
        else {
            Scanner ScanPlay = new Scanner(System.in);
            System.out.println("Joueur " + Joueur + " Veuillez saisir un nombre (x y) (colonne ligne)");
            String ReponseStr = ScanPlay.nextLine().replace(" ", "");

            if (ReponseStr.length() == 2) {
                int Reponsex = Character.getNumericValue(ReponseStr.charAt(0));
                int Reponsey = Character.getNumericValue(ReponseStr.charAt(1));
                if (IsPositionCorrect(Reponsex, Reponsey)) {
                    this.PlateauInt[Reponsey][Reponsex] = Joueur;
                }
                else {
                    System.out.println("Cette position n'est pas correcte, veuillez réessayer.");
                    TourDeJeu(Joueur);
                }
            }
            else {
                System.out.println("Erreur de frappe, veuillez réessayer.");
                TourDeJeu(Joueur);
            }    
        } 
    }
    
    public int[] TourIA(int depth, int Joueur) {
        int[] best = new int[] {-1, -1, -100}; // IA
        if (Joueur == 1) {
            best = new int[] {-1, -1, 100}; // Joueur humain
        }

        if (depth == 0 || this.EtatPartie() != 3) {
            int score = this.EtatPartie();
            return(new int[] {-1, -1, score});
        }

        for (int y=0; y<this.Size; y++) {
            for (int x=0; x<this.Size; x++) {
                if (this.PlateauInt[y][x] != 0) {
                    continue;
                }

                this.PlateauInt[y][x] = Joueur;
                int[] score = TourIA(depth-1, -Joueur);
                this.PlateauInt[y][x] = 0;
                score[0] = y; score[1] = x;
                System.out.println(score);

                if (Joueur == -1) {
                    if (score[2] > best[2]) {
                        best = score;
                        if (best[2] == 1) {
                            System.out.println("break***********************************************************");
                            break;
                        }
                    }
                }
                else {
                    if (score[2] < best[2]) {
                        best = score;
                        if (best[2] == -1) {
                            System.out.println("break----------------------------------------------------------");
                            break;
                        }
                    }
                }
            }
        }
        return(best);
    }

    public int EtatPartie(){
        // rend le numéro du joueur gangnant s'il y en a un, 3 si la partie est bloquée, 0 si tout va bien.
        // Test de gagnat sur les lignes
        for (int[] Ligne: this.PlateauInt) {
            int SommeLigne = 0;
            for (int Valeur: Ligne) {
                SommeLigne += Valeur;
            }
            if (SommeLigne == this.Size || SommeLigne == -this.Size) {
                return(SommeLigne/this.Size);
            }
        }

        // Test de gagnant sur les colonnes
        for (int i=0; i<this.Size; i++) {
            int SommeColonne = 0;
            for (int j=0; j<this.Size; j++) {
                SommeColonne += this.PlateauInt[j][i];
            }
            if (SommeColonne == this.Size || SommeColonne == -this.Size) {
                return(SommeColonne/this.Size);
            } 
        }

        // Test de gagnant sur les diagonnales
        int SommeDiag0 = 0;
        int SommeDiag1 = 0;
        for (int i=0; i<this.Size; i++) {
            SommeDiag0 += this.PlateauInt[i][i];
            SommeDiag1 += this.PlateauInt[i][this.Size-1-i];
        }
        if (SommeDiag0 == this.Size || SommeDiag0 == -this.Size) {
            return(SommeDiag0/this.Size);
        }
        else if (SommeDiag1 == this.Size || SommeDiag1 == -this.Size) {
            return(SommeDiag1/this.Size);
        }

        // Test de match nul
        int Nbr_Vide = 0;
        for (int[] Ligne: this.PlateauInt) {
            for (int Valeur: Ligne) {
                if (Valeur == 0) {
                    Nbr_Vide += 1;
                }
            }
        }
        if (Nbr_Vide == 0) {
            return(0);
        }

        // Tout va bien
        return(3);
    }

    public boolean IsPositionCorrect(int PosX, int PosY) {
        // PosX et PosY sont les positions x y courament utilisées le plateau utlise donc Plateau[PosY][PosX]
        if (PosX >= this.Size || PosY >= this.Size || PosX < 0 || PosY < 0) {
            return(false);
        }
        else if (this.PlateauInt[PosY][PosX] != 0) {
            return(false);
        }
        return(true);
    }
 
    public static void JouerUnePartie() throws IOException, InterruptedException  {
        //Choix des paramètres
        Scanner InitPartie = new Scanner(System.in);
        // Choix de la taille
        System.out.println("Entrez la taille du plateau : 3-10");
        int Taille = InitPartie.nextInt();
        Partie LaPartie = new Partie(Taille);
        // Choix du mode de jeu
        System.out.println("Souhaitez-vous jouer contre un autre joueur (0) ou contre l'ordinateur (1)");
        int Mode = InitPartie.nextInt();
        if (Mode == 0 || Mode == 1) {
            LaPartie.Mode = Mode;
        }
        else {
            System.out.println("Le mode choisit n'existe pas.");
            JouerUnePartie();
            return;
        }
            
        // Commencement de la partie
        boolean Termine = false;
        int TourJoueur = -1; // Random -1 ou 1 bientôt
        while (!Termine) {
            TourJoueur = TourJoueur*-1;

            // Clear les terminaux Unix (en calaboration avec StackOverflow)
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            System.out.println(LaPartie.toString());

            LaPartie.TourDeJeu(TourJoueur);
            int EtatPartie = LaPartie.EtatPartie();

            if (EtatPartie == 1 || EtatPartie == -1) {
                System.out.println("Le Joueur " + EtatPartie + " à gagné.");
                Termine = true;
            }
            else if (EtatPartie == 0) {
                System.out.println("La partie est bloquée, match nul.");
                Termine = true;
            }
        }

        System.out.println(LaPartie.toString());
        // Partie Terminée, on recommence ?
        Scanner ContinuePartie = new Scanner(System.in);
        System.out.println("Voulez-vous refaire une partie ? Y/N");
        String Reponse = ContinuePartie.nextLine();

        if (Reponse.equals("y") || Reponse.equals("Y")) {
            System.out.println("Ok, c'est repartis.");
            JouerUnePartie();
        }
        else {
            System.out.println("A plus.");
            ContinuePartie.close();
        }
    }

}
