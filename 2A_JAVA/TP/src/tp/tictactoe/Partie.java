
package tp.tictactoe; // Faite pas gaffe

import java.util.Scanner;


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
        
        String ReturnString = " ";//String.format("%"+this.Size*5+"s", "").replace(" ", "_") + "\n";
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
                    default: Sym = " ";
                }
                ReturnString += String.format("|%2s", Sym) + String.format("%1s", ""); // alternative  ->  ReturnString += j + " ";
            }
            ReturnString += "|" + "\n";
        }
        return(ReturnString);
    }

    public void TourDeJeu(int Joueur) {
        if (this.Mode == 1 && Joueur == -1) {
            // MiniMax bientôt
        }
        
        else {
            boolean CoupJoue = false;
            while (!CoupJoue) {
                Scanner ScanPlay = new Scanner(System.in);
                System.out.println("Joueur " + Joueur + " Veuillez saisir un nombre (x y)");
                String ReponseStr = ScanPlay.nextLine();

                int Reponsex = Character.getNumericValue(ReponseStr.charAt(0));
                int Reponsey = Character.getNumericValue(ReponseStr.charAt(2));

                if (IsPositionCorrect(Reponsex, Reponsey)) {
                    this.PlateauInt[Reponsey][Reponsex] = Joueur;
                    CoupJoue = true;
                }
                else {
                    System.out.println("Cette position n'est pas correcte, veuillez réessayer.");
                }   
            }
        } 
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
            return(3);
        }

        // Tout va bien
        return(0);
    }

    public boolean IsPositionCorrect(int PosX, int PosY) {
        // PosX et PosY sont les positions x y courament utilisées le plateau utlise donc Plateau[PosY][PosX]
        if (PosX >= this.Size || PosY >= this.Size) {
            return(false);
        }
        else if (this.PlateauInt[PosY][PosX] != 0) {
            return(false);
        }

        return(true);
    }

    public static void JouerUnePartie() {
        boolean Jouer = true;
        while (Jouer) {
            //Choix des paramètres
            Scanner InitPartie = new Scanner(System.in);
            // Choix de la taille
            System.out.println("Entrez la taille du plateau : 3-10");
            int Taille = InitPartie.nextInt();
            Partie LaPartie = new Partie(Taille);
            // Choix du mode de jeu
            System.out.println("Souhaitez-vous jouers contre un autre joueur (0) ou contre l'ordinateur (1)");
            int Mode = InitPartie.nextInt();
            if (Mode == 0 || Mode == 1) {
                LaPartie.Mode = Mode;

            }
            else {
                System.out.println("Le mode choisit n'existe pas.");

                break;
            }
            
            // Commencement de la partie
            boolean Termine = false;
            int TourJoueur = -1;
            while (!Termine) {
                TourJoueur = TourJoueur*-1;

                System.out.println(LaPartie.toString());

                LaPartie.TourDeJeu(TourJoueur);
                int EtatPartie = LaPartie.EtatPartie();

                if (EtatPartie == 1 || EtatPartie == -1) {
                    System.out.println("Le Joueur " + EtatPartie + " à gagné.");
                    Termine = true;
                }
                else if (EtatPartie == 3) {
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
                System.out.println("Ok, c'est repartis.");;
            }
            else {
                System.out.println("A plus.");
                Jouer = false;
                ContinuePartie.close();
            }
            
        }
    }


}
