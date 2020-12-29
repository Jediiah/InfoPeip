package tp.main;

import java.util.Scanner;
import java.io.IOException;


import tp.personne.*;
import tp.matrice.*;
import tp.tictactoe.*;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        //TestTP1 TestTp1 = new TestTP1();
        //TestTP2 TestTp2 = new TestTP2();

        //Personne TestPersonne = new Personne("mai", 28, 2001, "Zach");
        //TestPersonne.TestRun();

        //Matrice TestMatrice = new Matrice(5);
        //TestMatrice.TestRun()

        Partie TestPartie = new Partie();
        TestPartie.JouerUnePartie();
        //System.out.println(TestPartie.toString());
       
      
    }
}
