package tp.main;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


import tp.personne.*;
import tp.matrice.*;
import tp.tictactoe.*;

public class Main {
    
    public static void main(String[] args) {
        //TestTP1 TestTp1 = new TestTP1();
        //TestTP2 TestTp2 = new TestTP2();

       //Personne TestPersonne = new Personne("mai", 28, 2001, "Zach");
       //TestPersonne.TestRun();

       //Matrice TestMatrice = new Matrice(5);
       //TestMatrice.TestRun();

       Map<String, String> SymAffiche = new HashMap<String, String>();
       SymAffiche.put("0", " ");
       SymAffiche.put("1", "X");
       SymAffiche.put("-1", "O");


       Partie TestPartie = new Partie();
       //System.out.println(TestPartie.toString());
       TestPartie.JouerUnePartie();
      
    }
}
