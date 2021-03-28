package tp_jdr.Plateau;

import tp_jdr.Personnage.PersonnageJoueur;

public class Concert extends Evenement {
    
    public Concert() {
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

    public void Resultat(PersonnageJoueur MonPerso) {
        switch (this.Contenu) {
            case "Mainstage":
                MonPerso.ChgmtLieu("Mainstage");
                break;
            case "Warzone":
                MonPerso.ChgmtLieu("Warzone");
                break;
            case "Altar":
                MonPerso.ChgmtLieu("Altar");
                break;
            case "Temple":
                MonPerso.ChgmtLieu("Temple");
                break;
            default:
                MonPerso.ChgmtLieu("Valley");
                break;
        }
    }
}
