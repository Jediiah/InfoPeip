package tp_jdr.Plateau;

import tp_jdr.Personnage.PersonnageJoueur;

public class Concert extends Evenement {
    
    public Concert(Evenement Suite) {
        this.Suite = Suite;
        this.EvenementIntermediaire = true;

        int Scene = (int)(Math.random() * 5);
        switch (Scene) {
            case 1:
                this.Contenu = "Mainstage";
                break;
            case 2:
                this.Contenu = "Warzone";
                break;
            case 3:
                this.Contenu = "Altar";
                break;
            case 4:
                this.Contenu = "Temple";
                break;
            default:
                this.Contenu = "Valley";
                break;
        }
    }

    public void Resultat(PersonnageJoueur PJ) {

    }
}
