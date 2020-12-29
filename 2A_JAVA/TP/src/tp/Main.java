package tp.main;

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
            Personne TestPersonne = new Personne("janvier", 1, 2021, "TEST");
            TestPersonne.TestRun();

            Matrice TestMatrice = new Matrice(1);
            TestMatrice.TestRun();
        }

        Partie TestPartie = new Partie();
        TestPartie.JouerUnePartie();    

        RepMain.close();
    }
}
