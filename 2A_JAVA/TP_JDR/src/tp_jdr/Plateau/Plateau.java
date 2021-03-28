package tp_jdr.Plateau;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tp_jdr.Personnage.PersonnageJoueur;

public class Plateau {
    
    protected List<Evenement> Evenements = new ArrayList<Evenement>();
    protected Evenement EvenementCourant;
    protected PersonnageJoueur MonPerso;

    public Plateau(PersonnageJoueur MonPerso){
        this.MonPerso = MonPerso;

        for(int i=0; i<9; i++) {
            this.Evenements.add(new Concert());
            this.Evenements.add(new EvenementIntermediaire(false));
        }
        this.Evenements.add(0, new Shop());
        this.Evenements.add(9, new Shop());
        this.Evenements.add(18, new Shop());

        this.EvenementCourant = this.Evenements.get(0);
    }

    private boolean TourDeJeu() {
        this.EvenementCourant = this.Evenements.get(0);
        this.EvenementCourant.Resultat(this.MonPerso);

        if(this.EvenementCourant.Final) {
            return(false);
        }

        this.Evenements.remove(0);
        return(true);
    }

    private boolean TourJour() {
        Scanner Suite = new Scanner(System.in);
        for(int i=0; i<7; i++) {
            if(!this.TourDeJeu()) {
               return(false);
            }
            String Reponse = Suite.nextLine();
        }
        this.MonPerso.Dormir();
        
        return(true);
    }

    public boolean Festival() {
        for(int i=0; i<3; i++) {
            System.out.println(" \n" + " \n" + " \n" + " \n" + " \n" + " \n" + " \n" + " \n" + " \n" + " \n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
            System.out.println("Vous commencez le Jour " + (i+1) + "\n");
            if(!this.TourJour()) {
                return(false);
            }
        }

        return(true);
    }
}
