
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

    private void TourDeJeu(int Joueur) {
        if (this.Mode == 1 && Joueur == -1) {
            int[] BestMove = TourIA(0, Joueur, -10000, 10000);
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
    
    private int[] TourIA(int depth, int Joueur, int alpha, int beta) {  // Minimax alpha-beta
        // Cas final
        int EtatPartie = EtatPartie();
        if (EtatPartie != 3 || depth >= 5) {
            if (EtatPartie != 3) {
                // Si un des joueurs à gagné la valeur du noeud  
                // doit être +inf ou -inf 
                return(new int[] {-1, -1, Math.round((EtatPartie*1000)/depth)});
            }
            //System.out.println("Commence heuristique");
            int score = (EvalIA(EtatPartie, depth, Joueur) - EvalIA(EtatPartie, depth, -Joueur)) * Joueur;
            //System.out.println("finit heuristique");
            return(new int[] {-1, -1, score});
        }

        int [] best = new int[] {-1, -1, 0};// v=best[2] Wiki
        if (Joueur == -1) {
            best[2] = 1000; 
            for (int y=0; y<this.Size; y++) {
                for (int x=0; x<this.Size; x++) {
                    if (this.PlateauInt[y][x] != 0) {continue;}
                    
                    this.PlateauInt[y][x] = Joueur;
                    int[] score = TourIA(depth+1, -Joueur, alpha, beta);
                    if (beta > score[2]) {
                        beta = score[2];
                        best[0] = y; best[1] = x;
                    }
                    this.PlateauInt[y][x] = 0;
                    if (alpha >= beta) {
                        best[2] = beta;
                        return(best);
                    }
                }
            }
            best[2] = beta;
            return(best);
        }

        else if (Joueur == 1) {
            best[2] = -1000;
            for (int y=0; y<this.Size; y++) {
                for (int x=0; x<this.Size; x++) {
                    if (this.PlateauInt[y][x] != 0) {continue;}

                    this.PlateauInt[y][x] = Joueur;
                    int[] score = TourIA(depth+1, -Joueur, alpha, beta);
                    if (alpha < score[2]) {
                        alpha = score[2];
                        best[0] = y; best[1] = x;
                    }
                    this.PlateauInt[y][x] = 0;
                    if (beta <= alpha) {
                        best[2] = alpha;
                        return(best);
                    }
                }
            }
            best[2] = alpha;
            return(best);
        }
        return(best);
    }

    private int EvalIA(int EtatPartie, int depth, int Joueur) {
        boolean IsForkPossible = true;
        int CountPossibleForks = 0;
        int TotalJoueur = 0;
        // On regarde chaque ligne et ajoute 10 au total par case Joueur 
        // si l'autre joueur n'a pas de case sur cette ligne
        for (int[] Ligne: this.PlateauInt) {
            int SommeLigne = 0;
            for (int Valeur: Ligne) {
                if (Valeur == Joueur) {
                    SommeLigne += 10;
                }
                else if (Valeur == -Joueur) {
                    SommeLigne = 0;
                    break;
                }
            }
            TotalJoueur += SommeLigne;
            if (SommeLigne == (this.Size-1)*10) {IsForkPossible = false;}
            if (SommeLigne == (this.Size-2)*10) {CountPossibleForks++;}
        }

        // Idem pour les colonnes
        for (int x=0; x<this.Size; x++) {
            int SommeColonne = 0;
            for (int y=0; y<this.Size; y++) {
                if (this.PlateauInt[y][x] == Joueur) {
                    SommeColonne += 10;
                }
                else if (this.PlateauInt[y][x] == -Joueur) {
                    SommeColonne = 0;
                    break;
                }
            }
            TotalJoueur += SommeColonne;
            if (SommeColonne == (this.Size-1)*10) {IsForkPossible = false;}
            if (SommeColonne == (this.Size-2)*10) {CountPossibleForks++;}
        }

        // Idem pour les diagonales
        int SommeDiag0 = 0;
        int SommeDiag1 = 0;
        // Diagonale0
        for (int i=0; i<this.Size; i++) {
            if (this.PlateauInt[i][i] == Joueur) {
                SommeDiag0 += 10;
            }
            else if (this.PlateauInt[i][i] == -Joueur) {
                SommeDiag0 = 0;
                break;
            } 
        }
        // Diagonale1
        for (int i=0; i<this.Size; i++) {
            if (this.PlateauInt[i][this.Size-1-i] == Joueur) {
                SommeDiag1 += 10;
            }
            else if (this.PlateauInt[i][this.Size-1-i] == -Joueur) {
                SommeDiag1 = 0;
                break;
            }
        }
        TotalJoueur += SommeDiag0+SommeDiag1;
        if (SommeDiag0 == (this.Size-1)*10 || SommeDiag1 == (this.Size-1)*10) {IsForkPossible = false;}
        if (SommeDiag0 == (this.Size-2)*10) {CountPossibleForks++;}
        if (SommeDiag1 == (this.Size-2)*10) {CountPossibleForks++;}

        // On regarde si le joueur peut faire une fourchette au prochain coup
        // (il peut faire 2 lignes complètes après la fourchette)
        // Une fourchette possible ajoute 100 au total
        if (IsForkPossible && CountPossibleForks >= 2) {
            if (ChercherFourchettes(Joueur)) {TotalJoueur += 100;}
        }
        return(TotalJoueur/depth);
    }

    private boolean ChercherFourchettes(int Joueur) {
        for (int y=0; y<this.Size; y++) {
            for (int x=0; x<this.Size; x++) {
                if (this.PlateauInt[y][x] != 0) {continue;}

                this.PlateauInt[y][x] = Joueur;
                int NbrWinProchainCoup = 0;
                for (int[] Ligne: this.PlateauInt) {
                    int SommeLigne = 0;
                    for (int Valeur: Ligne) {
                        if (Valeur == Joueur) {
                            SommeLigne += 10;
                        }
                        else if (Valeur == -Joueur) {
                            SommeLigne = 0;
                            break;
                        }
                    }
                    if (SommeLigne == (this.Size-1)*10) {NbrWinProchainCoup++;}
                }
        
                // Idem pour les colonnes
                for (int i=0; i<this.Size; i++) {
                    int SommeColonne = 0;
                    for (int j=0; j<this.Size; j++) {
                        if (this.PlateauInt[j][i] == Joueur) {
                            SommeColonne += 10;
                        }
                        else if (this.PlateauInt[j][i] == -Joueur) {
                            SommeColonne = 0;
                            break;
                        }
                    }
                    if (SommeColonne == (this.Size-1)*10) {NbrWinProchainCoup++;}
                }
        
                // Idem pour les diagonales
                int SommeDiag0 = 0;
                int SommeDiag1 = 0;
                // Diagonale0
                for (int i=0; i<this.Size; i++) {
                    if (this.PlateauInt[i][i] == Joueur) {
                        SommeDiag0 += 10;
                    }
                    else if (this.PlateauInt[i][i] == -Joueur) {
                        SommeDiag0 = 0;
                        break;
                    } 
                }
                // Diagonale1
                for (int i=0; i<this.Size; i++) {
                    if (this.PlateauInt[i][this.Size-1-i] == Joueur) {
                        SommeDiag1 += 10;
                    }
                    else if (this.PlateauInt[i][this.Size-1-i] == -Joueur) {
                        SommeDiag1 = 0;
                        break;
                    }
                }
                if (SommeDiag0 == (this.Size-2)*10) {NbrWinProchainCoup++;}
                if (SommeDiag1 == (this.Size-2)*10) {NbrWinProchainCoup++;}

                this.PlateauInt[y][x] = 0;
                if (NbrWinProchainCoup >= 2) {return(true);}
            }
        }
        return(false);
    }

    private int EtatPartie(){
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

    private boolean IsPositionCorrect(int PosX, int PosY) {
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
