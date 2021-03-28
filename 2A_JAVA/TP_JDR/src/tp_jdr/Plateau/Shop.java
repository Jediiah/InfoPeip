package tp_jdr.Plateau;

import tp_jdr.Personnage.PersonnageJoueur;

public class Shop extends Evenement {


    public Shop() {
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
        switch (this.Contenu) {
            case "Biere":
                this.Biere(MonPerso);
                break;
            case "MerchUnderground":
                this.MerchUnderdroung(MonPerso);
                break;
            default:
                this.Eau(MonPerso);
                break;
        }
    }

    //Objets Possibles

    // Buff le plus courant : 75%
    private void Biere(PersonnageJoueur MonPerso) {
        System.out.println("Quelle chance, vous trouvez une bière abandonnée en plein soleil." + "\n" +
                            "Bien que le goût soit horrible vous ne pouvez résister à ce doux brevage.");
        MonPerso.Boire(0.2);
    }

    // Buff le moins courrant 5%
    private void Eau(PersonnageJoueur MonPerso) {
        System.out.println("Vous croisez le chemin d'une fontaine d'eau, c'est extrêmement rare." + "\n" +
                            "Vous buvez abondemment et regagnez 20 de vie");
        MonPerso.AugmenteVie(25);
    }

    // 20%
    private void MerchUnderdroung(PersonnageJoueur MonPerso) {
        System.out.println("Vous allez dans un magasin de merchandising et trouvez un super patch au fond du tas" + "\n" +
                            "Le vendeur n'a jamais entendu parler du groupe et vous en fait cadeau : VieMax + 10");
        MonPerso.AugmenteVieMax(10);
    }
}