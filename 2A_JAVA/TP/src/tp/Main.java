package tp;

import java.util.Scanner;
import java.io.IOException;


import tp.personne.*;
import tp.matrice.*;
import tp.tictactoe.*;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner RepMain = new Scanner(System.in);
        System.out.println("Voulez-vous voir les tests des TP 1 et 2 ? (Y/N)");
        String RepTP = RepMain.nextLine();

        if (RepTP.equals("y") || RepTP.equals("Y")) {
            System.out.println("\n" + "TP1 - Personnes *****************************************" + "\n");
            Personne TestPersonne = new Personne("janvier", 1, 2021, "TEST");
            TestPersonne.TestRun();

            System.out.println("\n" + "TP3 - Matrices *****************************************" + "\n");
            Matrice TestMatrice = new Matrice(1);
            TestMatrice.TestRun();
        }

        System.out.println("\n" + "TP2 - TicTacToe *****************************************" + "\n");
        Partie TestPartie = new Partie();
        TestPartie.JouerUnePartie();    

        RepMain.close();
    }
}
