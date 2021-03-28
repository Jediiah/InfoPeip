package tp_jdr.Partie;

import java.util.Scanner;

import tp_jdr.Personnage.EtudientFauche;
import tp_jdr.Personnage.FestivalierEndurci;
import tp_jdr.Personnage.PersonnageJoueur;
import tp_jdr.Plateau.Plateau;

public class Partie {
    
    public static void main(String[] args) {
        System.out.println("Bonjour ceci est un jeu de survie prenant place dans un grand festival de métal bien connu des bretons." + "\n" +
                            "Votre but est de survivre à ces trois jours à la fois abominables et manifiques.");
        System.out.println("Vous perdez lorsque votre vie ou votre hydratation tombe à 0 ou lorsque votre taux d'alcool dépasse 1.");
        
        System.out.println("\n"  + "Pour cela vous devez choisir un personnage" + "\n" +
                            "EtudiantFauché pour les pros (1) et FestivalierEndurci pour les noob (2)."); 

        Scanner ReponseJoueur = new Scanner(System.in);
        String PersoChoisi = ReponseJoueur.nextLine();

        PersonnageJoueur MonPerso;
        if(PersoChoisi.equals("1")) {
            MonPerso = new EtudientFauche();
        }
        else {
            MonPerso = new FestivalierEndurci();
        }

        System.out.println("Vous avez choisi " + MonPerso.getNomClasse());
        System.out.println(MonPerso.toString());
        System.out.println("\n"  + "Voulez-vous commencer ? (Y/N) " + "\n");

        String Reponse = ReponseJoueur.nextLine();
        if(Reponse.equals("Y") || Reponse.equals("y")) {
            Plateau MonPlato = new Plateau(MonPerso);
            if(!MonPlato.Festival()) {
                System.out.println("Game Over");
                if(MonPerso.getTauxAlcool() > 1) {
                    System.out.println("Vous avez trop bu et finnissez le festival à la Croix Rouge. Dommage!");
                }
                else if(MonPerso.getVieActuel() < 1) {
                    System.out.println("Un ennemi vous a tuer. Vous ferez mieux l'année prochaine.");
                }
                else if(MonPerso.getHydratation() < 1) {
                    System.out.println("Vous êtes mort de soif.");
                }
            }
            else {
                System.out.println("Bravo vous avez réussi à survire 3 jours aux enfers.");
            }
        }
        else {
            System.out.println("Ok .");
        }

    }
}
