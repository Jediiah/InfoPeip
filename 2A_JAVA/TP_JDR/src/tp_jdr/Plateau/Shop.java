package tp_jdr.Plateau;

import tp_jdr.Personnage.PersonnageJoueur;

public class Shop extends Evenement {


    public Shop(String Contenu, Evenement Suite) {
        this.Suite = Suite;

        int Buff = (int)(Math.random() * 100);
        if(1<=Buff && Buff<76){
            this.Contenu = "Biere";
        } 
        else if(76<=Buff && Buff<97) {
            this.Contenu = "MerchUnderground";
        }
        else if(97<=Buff) {
            this.Contenu = "Eau";
        }
    }

    public void Resultat(PersonnageJoueur MonPerso) {
        
    }

    //Objets Possibles

    // Buff le plus courant : 75%
    private void Biere(PersonnageJoueur MonPerso) {
        MonPerso.Boire(0.2);
    }

    // Buff le moins courrant 5%
    private void Eau(PersonnageJoueur MonPerso) {
        MonPerso.Heal(25);
    }

    // 20%
    private void MerchUnderdroung(PersonnageJoueur MonPerso) {
        MonPerso.AugmenteVieMax(10);
    }
}