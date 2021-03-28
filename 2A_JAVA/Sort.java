import java.util.Arrays;
import java.util.stream.IntStream;

public class Sort {

    static boolean isSorted(int[] t){
        // O(n)
        if(t.length == 0){return(true);}
        int NbDepart = t[0];
        for(int nb: t) {
            if(nb < NbDepart) {
                return(false);
            }
            NbDepart = nb;
        }
        return(true);
    }

    static int linSearch(int[] t, int a) {
        // O(n)
        if(t.length == 0){return(-1);}
        for(int i=0; i<t.length; i++) {
            if(t[i] == a) {
                return(i);
            }
        }
        return(-1);
    }

    static int DichoSearch(int[] t, int a) {
        // O(log(n))
        if(t.length == 0){return(-1);}
        int Debut = 0;
        int Fin = t.length-1;
        while(Debut <= Fin) {
            int M = (int)(Fin-Debut)/2;
            if(t[M] == a){
                return(M);
            }
            else if(t[M] < a) {
                Fin = M-1;
            }
            else if(t[M] > a) {
                Debut = M+1;
            }
        }
        return(-1);
    }

    static int maxAdjacentK(int[] t, int Debut, int K) {
        // par recursion / initialiser à Debut=0
        int NbK = 0;
        if(Debut >= t.length-1){return(0);}
        while(Debut<t.length && t[Debut] == K){
            NbK++;
            Debut++;
        }

        int NextNbK = maxAdjacentK(t, Debut+1, K);
        if(NextNbK > NbK) {
            NbK = NextNbK;
        }

        return(NbK);
    }
        
    static int NombreDeK(int[] t, int k) {
        int NbK = 0;
        for(int Nombre: t) {
            if(Nombre==k) {
                NbK++;
            }
        }
        return(NbK);
    }

    static int MinIndex(int[] tab, int deb, int fin) {
        int min = deb;
        for(int i=deb; i<=fin; i++) {
            if(tab[min]>tab[i]){
                min = i;
            }
        }
        return(min);
    }

    static void countingSort(int[] t, int k) {
        int[] tabCompte = new int[k+1];
        for(int i=0; i<k+1; i++) {
            tabCompte[i] = NombreDeK(t, i);
        }

        int Debut = 0;
        for(int j=0; j<k+1; j++){
            int NbIndex = tabCompte[j];
            for(int i=0; i<NbIndex; i++) {
                t[Debut+i] = j;
            }
            Debut+=NbIndex;
        }
    }

    static void TriABulle(int[] tab) {
        for(int i=tab.length-1; i>0; i--) {
            boolean IsTrie = true;
            for(int j=0; j<i; j++) {
                if(tab[j+1] < tab[j]) {
                    swap(tab, j+1, j);
                }
                IsTrie = false;
            }
            if(IsTrie){
                break;
            }
        } 
    }

    static void TriSelection(int[] tab) {
        for(int i=0; i<tab.length-1; i++) {
            int min = MinIndex(tab, i, tab.length-1);
            if(min != i) {
                swap(tab, i, min);
            }
        }
    }

    static void displayTab(int[] tab){
        //Affiche tableau
        for (int i: tab) {
            System.out.print(i + " ");
        }
        System.out.println();
    }	

    static int[] RandomTab(int n, int r) {
        return(IntStream.generate(() -> {return (int)(Math.random() * r); }).limit(n).toArray());
    }

    static void swap(int[] tab, int i, int j) {
        int SwapTemp = tab[i];
        tab[i] = tab[j];
        tab[j] = SwapTemp;
    }

    public static void main(String[] args) {
        /*
        int[] tab = new int[]{6,2,3,7,3,4,1};
        boolean tabSorted = isSorted(tab);
        Arrays.sort(tab);
        int IndRecherche = DichoSearch(tab, 5);
        System.out.println(tabSorted);
        System.out.println(IndRecherche);

        tab = new int[]{6};
        tabSorted = isSorted(tab);
        IndRecherche = DichoSearch(tab, 6);
        System.out.println(tabSorted);
        System.out.println(IndRecherche);

        tab = new int[]{2,6};
        tabSorted = isSorted(tab);
        //IndRecherche = DichoSearch(tab, 3);
        System.out.println(tabSorted);
        System.out.println(IndRecherche);
        */

        int[] tab = RandomTab(100, 99);
        displayTab(tab);
        System.out.println(" ----- ");
        TriSelection(tab);
        displayTab(tab);
        //System.out.println(maxAdjacentZeros(tab, 0));
    }
}
