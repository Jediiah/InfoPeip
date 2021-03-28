package tp_jdr.Plateau;

import java.util.Scanner;

import tp_jdr.Personnage.*;

public class EvenementIntermediaire extends Evenement {
    
    public EvenementIntermediaire(boolean Final) {
        this.Final = Final;

        int Event = (int)(Math.random() * 100);
        if(1<=Event && Event<75){
            this.Contenu = "Combat";
        } 
        else if(75<=Event && Event<86) {
            this.Contenu = "Fontaine";
        }
        else if(86<=Event && Event<97) {
            this.Contenu = "ToilettesSeches";
        }
        else if(97<=Event) {
            this.Contenu = "Environnement";
        }
    }

    public void Resultat(PersonnageJoueur MonPerso) {
        switch (this.Contenu) {
            case "Combat":
                this.Combat(MonPerso, this.randomEnnemi());
                break;
            case "Fontaine":
                this.Fontaine(MonPerso);
                break;
            case "ToilettesSeches":
                this.ToilettesSeches(MonPerso);
                break;
            default:
                this.Environnement(MonPerso);
                break;
        }
    }

    private void Combat(PersonnageJoueur MonPerso, Ennemi Ennemi) {
        boolean Fin = false;
        System.out.println("Vous tombez face à un " + Ennemi.getNomClasse());
        System.out.println(Ennemi.toString());

        System.out.println("Voici vos stats : " + "\n" + MonPerso.toString());
        while(!Fin) {
            boolean MonPersoJouer = false;
            boolean EnnemiJouer = false;
            int MonPersoParrade;
            Scanner ReponseJoueur = new Scanner(System.in);

            System.out.println(" \n" + " \n" + " \n" + " \n");
            System.out.println("Votre vie = " + MonPerso.getVieActuel() + "\n" +
                                "Vie de " + Ennemi.getNomClasse() + " = " + Ennemi.getVieActuel());      

            System.out.println("Voulez vous attaquer (1)? Ou parer la prochaine attaque (2)");
            MonPersoParrade = ReponseJoueur.nextInt();

            if(MonPersoParrade == 1) {
                System.out.println("Vous attaquez " + Ennemi.getNomClasse());
                Ennemi.SubirAttaque(MonPerso);
                MonPersoJouer = true;
            }
            else {
                System.out.println(Ennemi.getNomClasse() + " vous attaque");
                MonPerso.EsquiverAttaque(Ennemi);
                EnnemiJouer = true;
                MonPersoJouer = true;
            }

            if(!EnnemiJouer) {
                System.out.println(Ennemi.getNomClasse() + " vous attaque");
                MonPerso.SubirAttaque(Ennemi);
                EnnemiJouer = true;
            }

            if(!MonPerso.isAlive()) {
                this.Final = true;
                Fin = true;
            }
            if(!Ennemi.isAlive()) {
                System.out.println("Vous avez vaincu" + Ennemi.getNomClasse() + ", bien jouer");
                Fin = true;
            }
        }
            
    }

    private void Fontaine(PersonnageJoueur MonPerso) {
        System.out.println("Vous croisez le chemin d'une fontaine d'eau, c'est extrêmement rare." + "\n" +
                            "Vous buvez abondemment : +10 de Vie et +10 d'Hydratation");
        MonPerso.AugmenteVie(10);
        MonPerso.AugmenteHydrate(10);
    }

    private void ToilettesSeches(PersonnageJoueur MonPerso) {
        System.out.println("Vous avez une envie pressente mais il y à la queue aux toilettes sèches" + "\n" +
                            "-10 de Vie et -50 d'Hydratation");
        MonPerso.AugmenteVie(-10);
        MonPerso.AugmenteHydrate(-50);
    }

    private void Environnement(PersonnageJoueur MonPerso) {
        String MeteoActuelle = MonPerso.getMeteo();
        
        int NewMeteoInt = (int)(Math.random()*3);
        String NouvelleMeteo;
        switch (NewMeteoInt) {
            case 1:
                NouvelleMeteo = "Pluie";
                break;
            case 2:
                NouvelleMeteo = "Canicule";
                break;
            default:
                NouvelleMeteo = "Normale";
                break;
        }

        if(NouvelleMeteo.equals(MeteoActuelle)){
            this.Environnement(MonPerso);
        }
        MonPerso.ChgmtMeteo(NouvelleMeteo);
    }

    private Ennemi randomEnnemi() {
        int randomNbr = (int)(Math.random()*3);
        switch (randomNbr) {
            case 1:
                return(new FanDeMetalica());
            case 2:
                return(new FanDeNightwish());
            default:
                return(new FanDeMayhem());
        }
    }
}
