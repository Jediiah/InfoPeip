package tp.tictactoe;

//import tp.matrice.*;
// Faite pas gaffe au dessus

import java.util.Scanner;

public class Partie {
    
    int[][] PlateauInt; //Pour Vous
    //Matrice Plateau;


    public Partie() {
        //this.Plateau = new Matrice(new int[3][3]);
        this.PlateauInt = new int[3][3]; // Pour Vous
    }

    public String toString() {

        String ReturnString = "";

        for (int[] i: this.PlateauInt) {
            for (int j: i) {
                ReturnString += String.format("%-6d", j); //ReturnString += j + " ";
            }
            ReturnString += "\n";
        }
        return(ReturnString);
    }

    public void TourDeJeu(int Joueur) {
        Scanner ScanPlay = new Scanner(System.in);
        System.out.println("Joueur " + Joueur + " Veuillez saisir un nombre (x y)");
        String ReponseStr = ScanPlay.nextLine();

        int Reponsey = Character.getNumericValue(ReponseStr.charAt(0));
        int Reponsex = Character.getNumericValue(ReponseStr.charAt(2));

        ScanPlay.close();

        this.PlateauInt[Reponsex][Reponsey] = Joueur;
    }
    
    public int EtatPartie(){
        for (int[] Ligne: this.PlateauInt){
            int SommeLigne = Ligne[0]+Ligne[1]+Ligne[2];
            if (SommeLigne == 3 || SommeLigne == -3) {
                return(SommeLigne/3);
            }
        }

        for (int i=0; i<3; i++){
            int SommeColonne = this.PlateauInt[0][i] + this.PlateauInt[1][i] + this.PlateauInt[2][i];
            if (SommeColonne == 3 || SommeColonne == -3) {
                return(SommeColonne/3);
            } 
        }

        int SommeDiag0 = 0;
        int SommeDiag1 = 0;
        for (int i=0; i<3; i++) {
            SommeDiag0 += this.PlateauInt[i][i];
            SommeDiag1 += this.PlateauInt[i][2-i];
        }
        if (SommeDiag0 == 3 || SommeDiag0 == -3) {
            return(SommeDiag0/3);
        }
        else if (SommeDiag1 == 3 || SommeDiag1 == -3) {
            return(SommeDiag1/3);
        }

        return(0);
    }

    public void JouerUnePartie(){

    }


}
