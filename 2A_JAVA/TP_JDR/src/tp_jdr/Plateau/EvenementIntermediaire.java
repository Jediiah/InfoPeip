package tp_jdr.Plateau;

import tp_jdr.Personnage.*;

public class EvenementIntermediaire extends Evenement {
    
    public EvenementIntermediaire(Evenement Suite) {
        this.Suite = Suite;

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

    }

    private void Fontaine(PersonnageJoueur MonPerso) {
        MonPerso.AugmenteVie(10);
        MonPerso.AugmenteHydrate(10);
    }

    private void ToilettesSeches(PersonnageJoueur MonPerso) {
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
                return(new FanDeMetalica);
                break;
            case 2:
                return(new FanDeNightwish);
                break;
            default:
                return(new FanDeMayhem);
                break;
        }
    }
}
