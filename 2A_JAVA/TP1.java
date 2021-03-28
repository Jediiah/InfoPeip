import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Random;

public class TP1 {

    public static int[] SousTabMaxNaif(int[] tab) {
        int SommeIter = 0;
        int SommeIterMax = 0;
        int SommeMax = 0;
        int IndiceGauche = 0;
        int IndiceDroite=0;

        for(int i=0; i<tab.length; i++) {
            SommeIterMax = 0;
            SommeIter = 0;
            for(int j=i; j<tab.length; j++) {
                SommeIter += tab[j];
                if(SommeIter > SommeIterMax) {
                    SommeIterMax = SommeIter;
                    if(SommeIterMax > SommeMax){
                        IndiceDroite = j;
                    }
                }
            }
            if(SommeIterMax >= SommeMax) {
                SommeMax = SommeIterMax;
                IndiceGauche = i;
            }
        }

        return(new int[]{SommeMax, IndiceGauche, IndiceDroite});
    }

    private static int[] SousTabMil(int[] tab, int deb, int fin) {
        int SommeIterGauche = 0;
        int SommeIterDroite = 0;
        int SommeIterMaxGauche = 0;
        int SommeIterMaxDroite = 0;
        int SommeMax = 0;
        int IndiceGauche = 0;
        int IndiceDroite = 0;
        
        int mil = (int) (fin-deb)/2 + deb;
        int milDroit = 0;
        int milGauche = 0;

        if((deb-fin+1)%2 == 0) {
            // Si il y a un nombre pair d'élément entre deb et fin
            // le milieu exact est entre deux éléments et on démarre de ces deux éléments de chaque coté du milieu
            milDroit = mil+1;
            milGauche = mil;
        }
        else {
            // Si il y a un nombre impair d'élément entre deb et fin
            // le milieu est un élément du tableau et on démare de ce meme élément des deux cotés
            // On soustrait une fois le milieux à la somme finale car il y sera, en conséquence, compté deux fois
            milDroit = mil;
            milGauche = mil;
            SommeMax = -tab[mil];
        }

        IndiceGauche = milGauche;
        IndiceDroite = milDroit;
        SommeIterMaxGauche = tab[milGauche];
        SommeIterMaxDroite = tab[milDroit];

        for(int i=0; i<=mil-deb; i++) {
            SommeIterGauche += tab[milGauche - i];
            SommeIterDroite += tab[milDroit + i];

            if(SommeIterGauche > SommeIterMaxGauche) {
                SommeIterMaxGauche = SommeIterGauche;
                IndiceGauche = milGauche - i;
            }
            if(SommeIterDroite > SommeIterMaxDroite) {
                SommeIterMaxDroite = SommeIterDroite;
                IndiceDroite = milDroit + i;
            }
        }

        SommeMax += SommeIterMaxGauche + SommeIterMaxDroite;
        return(new int[]{SommeMax, IndiceGauche, IndiceDroite});
    }

    private static int[] SousTabRec(int[] tab, int deb, int fin) {

        if(deb==fin) {
            return(new int[]{tab[deb], deb, deb});
        }

        
    }

    public static int[] RandomTab(int Taille) {
        // Créer une "liste" de n (Taille) nombres compris entre 
        // -100 et 100 exclus, puis convertis la "liste" en tableau.
        return(IntStream.generate(() -> {return (int)(new Random().nextInt(100 + 100) - 100); }).limit(Taille).toArray());
    }

    public static void displayTab(int[] tab){
        //Affiche le tableau
        for (int i: tab) {
            System.out.print(i + " ");
        }
        System.out.println();
    }	

    public static void main(String[] args) {
        int[] tab = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        displayTab(tab);
        displayTab(SousTabMil(tab, 0, 1));
    }
}
