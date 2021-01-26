package tp_jdr.Plateau;

import tp_jdr.Personnage.PersonnageJoueur;

public class Concert extends Evenement {
    
    public Concert(String Contenu, Evenement Suite) {
        this.Contenu = Contenu;
        this.Suite = Suite;
        this.EvenementIntermediaire = true;
    }

    public void Resultat(PersonnageJoueur PJ) {

    }
}
