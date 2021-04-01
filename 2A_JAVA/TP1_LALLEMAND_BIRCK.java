import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Random;

public class TP1_LALLEMAND_BIRCK {

    public static int[] SousTabMaxNaif(int[] tab) {
        /*
        Fonction SousTabNaif(tab):
            n = longueur de tab
            SommeMax = 0

            Pour i de 0 à n:
                SommeIter = 0
                SommeIterMax = 0

                Pour j de i à n:
                    SommeIter += tab[j]

                    Si SommeIter > SommeIterMax:
                        SommeIterMax = SommeIter

                        Si SommeIterMax > SommeMax:
                            IndiceDroite = j
                
                Si SommeIterMax >= SommeMax:
                    SommeMax = SommeIterMax
                    IndiceGauche = i

            Retourner [SommeMax, IndiceGauche, IndiceDroite]
        */

        int SommeIter = 0;
        int SommeIterMax = 0;
        int SommeMax = 0;
        int IndiceGauche = 0;
        int IndiceDroite=0;

        for(int i=0; i<tab.length; i++) {
            // Pour chaque indice de tab, fait la somme de tous les elements à sa droite pas à pas
            // La somme maximale de chaque indice repousse l'indice final de droite
            // et ramène l'indice final de gauche. 
            // Le sous tableau rendu est toujours le plus petit possible.
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
                // Pas forcemment necessaire car deja tester plus haut
                // mais permet de toujours rendre le sous tableau le plus petit possible
                SommeMax = SommeIterMax;
                IndiceGauche = i;
            }
        }

        return(new int[]{SommeMax, IndiceGauche, IndiceDroite});
    }

    private static int[] SousTabMil(int[] tab, int deb, int fin) {
        // Cherche le sous tableau maximal de chaque cote du milieu entre deb et fin
        // puis associe ces deux tableaux

        /*
        Fonction SousTabMil(tab, deb, fin):
            n = longueur de tab
            SommeMax = 0
            mil = partie entière de (fin-deb)/2 + deb

            Si le nombre d'elements entre deb et fin (inclus) est pair:
                milDroit = mil + 1
                milGauche = mil
            Sinon:
                milDroit = mil
                milGauche = mil
                SommeMax = -tab[mil]

            IndiceGauche = milGauche
            IndiceDroite = milDroit
            SommeIterMaxGauche = tab[milGauche]
            SommeIterMaxDroite = tab[milDroit]

            Pour i de 0 à (mil-deb):
                SommeIterGauche += tab[milGauche - i
                SommeIterDroite += tab[milDroit + i]

                Si SommeIterGauche > SommeIterMaxGauche:
                    SommeIterMaxGauche = SommeIterGauche
                    IndiceGauche = milGauche - i
            
                Si SommeIterDroite > SommeIterMaxDroite:
                    SommeIterMaxDroite = SommeIterDroite
                    IndiceDroite = milDroit + i

            SommeMax += SommeIterMaxGauche + SommeIterMaxDroite
            Retourner [SommeMax, IndiceGauche, IndiceDroite]
        */

        int SommeIterGauche = 0;
        int SommeIterDroite = 0;
        int SommeIterMaxGauche = 0;
        int SommeIterMaxDroite = 0;
        int SommeMax = 0;
        int IndiceGauche = 0;
        int IndiceDroite = 0;
        
        int mil = (int) (fin+deb)/2;
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
        /*
        Fonction SousTabRec(tab, deb, fin)
            Si deb = fin:
                Retourner [tab[deb], deb, deb]

            mil = partie entiere de (fin-deb)/2 + deb

            SommeGauche = SousTabRec(tab, deb, mil)
            SommeDroite = SousTabRec(tab, mil+1, fin)
            SommeMil = SousTabMil(tab, deb, fin)

            Si SommeMil[0] > SommeGauche[0]:
                Si SommeMil[0] > SommeDroite[0]:
                    Retourner SommeMil

                Retourner SommeDroite
            Sinon Si SommeGauche[0] >= SommeDroite[0]:
                Retourner SommeGauche
            
            Retourner SommeDroite
        */
        if(deb==fin) {
            return(new int[]{tab[deb], deb, deb});
        }

        int mil = (int) (fin+deb)/2;

        int[] SommeGauche = SousTabRec(tab, deb, mil);
        int[] SommeDroite = SousTabRec(tab, mil+1, fin);
        int[] SommeMil = SousTabMil(tab, deb, fin);

        // Retourne la somme maximale et les indices correspondants
        if(SommeMil[0] >= SommeGauche[0]) {
            if(SommeMil[0] >= SommeDroite[0]) {
                return(SommeMil);
            }
            return(SommeDroite);
        }
        else if(SommeGauche[0] > SommeDroite[0]) {
            return(SommeGauche);
        }
        return(SommeDroite);
    }

    private static int[] SousTabBonus(int[] tab) {
        /*
        Fonction SousTabBonus(tab)
            x = 0
            n = longueur de tab
            SommeMax = tab[0]
            SommeIter = 0

            Pour y de 0 à n:
                Si SommeIter < 0:
                    SommeIter = 0
                    x = y
                
                SommeIter += tab[y]

                Si SommeIter > SommeMax:
                    SommeMax = SommeIter
                    IndiceGauche = x
                    IndiceDroite = y
                
            Retourner [SommeMax, IndiceGauche, IndiceDroite]
        */
        int SommeIter = 0;
        int SommeMax = tab[0];
        int IndiceGauche = 0;
        int IndiceDroite=0;

        int x = 0;

        for(int y=0; y<tab.length; y++) {
            if(SommeIter < 0) {
                SommeIter = 0;
                x = y;
            }

            SommeIter += tab[y];

            if(SommeIter > SommeMax) {
                SommeMax = SommeIter;
                IndiceGauche = x;
                IndiceDroite = y;
            }
        }

        return(new int[]{SommeMax, IndiceGauche, IndiceDroite});
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
        System.out.println("Résultats des fonctions sur le tableau en exemple : ");
        displayTab(tab);
        System.out.println("Fonction SousTabMaxNaif :");
        displayTab(SousTabMaxNaif(tab));
        System.out.println("Fonction SousTabRec :");
        displayTab(SousTabRec(tab, 0, 15));
        System.out.println("Fonction SousTabBonus :");
        displayTab(SousTabBonus(tab));

        System.out.println("Résultats des fonctions sur un tableau de 99 elements aléatoires : ");
        // On essaye cette fois avec un nobre impair d'éléments
        tab = RandomTab(100);
        displayTab(tab);
        System.out.println("Fonction SousTabMaxNaif :");
        displayTab(SousTabMaxNaif(tab));
        System.out.println("Fonction SousTabRec :");
        displayTab(SousTabRec(tab, 0, 99));
        System.out.println("Fonction SousTabBonus :");
        displayTab(SousTabBonus(tab));
    }
}
