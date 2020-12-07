
package tp.matrice;

import java.util.stream.IntStream;
import java.util.Arrays;

public class Matrice {

    protected int[][] Matrice;
    protected int[] Size;


    public Matrice(int Taille) {
        this.Size = new int[]{Taille, Taille}; 
        this.Matrice = new int[Taille][Taille];
        for (int i=0; i<Taille;i++) {
            this.Matrice[i] = IntStream.generate(() -> {return (int)(Math.random() * 10); }).limit(Taille).toArray();
        }
    }

    public Matrice(int[][] Matrice) {
        int xMax = 0;
        for (int[] ligne: Matrice) {
            if (ligne.length > xMax) {
                xMax = ligne.length;
            }
        }
        this.Size = new int[]{Matrice.length, xMax};
        this.Matrice = new int[Matrice.length][xMax];
        int i = 0, j = 0;
        for (int[] ligne: Matrice) {
            for (int coef: ligne) {
                this.Matrice[i][j] = coef;
                j++;
            }
            j = 0;
            i++;
        }
    }

    public int[][] getMatrice() {
        return(this.Matrice);
    }

    public int[] getSize() {
        return(this.Size);
    }

    public int SumDiagonal() {
        int ReturnSum = 0;
        for (int i=0; i<Math.min(this.Size[0], this.Size[1]); i++) {
            ReturnSum += this.Matrice[i][i];
        }
        return(ReturnSum);
    }

    public void Add(Matrice toAdd) {
        if (Arrays.equals(this.Size, toAdd.Size)){
            for (int i=0; i<this.Size[0]; i++){
                for (int j=0; j<this.Size[1]; i++) {
                    this.Matrice[i][j] += toAdd.Matrice[i][j];
                }
            }
        }
        else {
            System.out.println("Les matrices que vous essayez d'additionner ne font pas la même taille.");
        }
    }

    public static Matrice Sum(Matrice Mat1, Matrice Mat2) {
        try {
            Matrice ReturnMatrice = new Matrice(new int[Mat1.Size[0]][Mat1.Size[1]]);
            for (int i=0; i<Mat1.Size[0]; i++){
                for (int j=0; j<Mat1.Size[1]; i++) {
                    ReturnMatrice.Matrice[i][j] = Mat1.Matrice[i][j] + Mat2.Matrice[i][j];
                }
            }
            return(ReturnMatrice);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Les matrices que vous essayez d'additionner ne font pas la même taille.");
            System.out.println("La matrice rendue est vide.");
            Matrice ReturnMatrice = new Matrice(0);
            return(ReturnMatrice);
        }
    }

    public void MutipleTo(Matrice MatMultiple) {
        if (this.Size[0] == MatMultiple.Size[1]) {
            int[][] MatResult = new int[this.Size[0]][this.Size[1]];
            for (int Rx=0; Rx<this.Size[0]; Rx++){
                for (int i=0; i<MatMultiple.Size[1]; i++) {
                    for (int j=1; j<this.Size[1]; j++) {
                        MatResult[i][Rx] += this.Matrice[i][j]*MatMultiple.Matrice[j][Rx];
                    }
                }
            }
            this.Matrice = MatResult;            
        }
        else {
            System.out.println("Les matrices que vous essayez de multiplier ne font pas la bonne taille.");
        }
    }

    public static Matrice Multiplication(Matrice Mat1, Matrice Mat2) {
        try {
            Matrice ReturnMatrice = new Matrice(new int[Mat1.Size[1]][Mat2.Size[0]]);
            for (int Rx=0; Rx<Mat1.Size[0]; Rx++){
                for (int i=0; i<Mat2.Size[1]; i++) {
                    for (int j=1; j<Mat1.Size[1]; j++) {
                        ReturnMatrice.Matrice[i][Rx] += Mat1.Matrice[i][j]*Mat2.Matrice[j][Rx];
                    }
                }
            }
            return(ReturnMatrice);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Les matrices que vous essayez de multiplier ne font pas la bonne taille.");
            System.out.println("La matrice rendue est vide.");
            Matrice ReturnMatrice = new Matrice(0);
            return(ReturnMatrice);
        }
    }

    public void Transpose() {
        int[][] MatResult = new int[this.Size[1]][this.Size[0]];
        for (int i=0; i<this.Size[0]; i++){
            for (int j=0; j<this.Size[1]; j++) {
                MatResult[j][i] = this.Matrice[i][j];
            }
        }
        this.Matrice = MatResult;
    }

    public Matrice getTranspose() {
        Matrice ReturnMatrice = new Matrice(new int[this.Size[1]][this.Size[0]]);
        for (int i=0; i<this.Size[0]; i++){
            for (int j=0; j<this.Size[1]; j++) {
                ReturnMatrice.Matrice[j][i] = this.Matrice[i][j];
            }
        }
        return(ReturnMatrice);
    }

    public boolean isSymetrique() {
        return(Arrays.deepEquals(this.Matrice, this.getTranspose().Matrice));
    }

    public String toString() {
        String ReturnString = "";

        for (int[] i: this.Matrice) {
            for (int j: i) {
                ReturnString += String.format("%-6d", j);
            }
            ReturnString += "\n";
        }
        return(ReturnString);
    }

    public void TestRun() {
        //Tableau TabloTest = new Tableau(10);
        //System.out.println(TabloTest.toString());
        //System.out.println(TabloTest.MaxNb());

        Matrice MaMatrice = new Matrice(5);
        System.out.println("Création d'une matrice carrée 5x5 : ");
        System.out.println(MaMatrice.toString());
        System.out.println("Somme des coefficients diagonaux : " + MaMatrice.SumDiagonal() + "\n");

        MatriceSymetrique MatSym = new MatriceSymetrique(5);
        System.out.println("Création d'une matrice symétrique carrée 5x5 : ");
        System.out.println(MatSym.toString());
        System.out.println("Teste de symétrie" + MatSym.isSymetrique() + "\n");

        Tableau Tab1 = new Tableau(4);
        Tableau Tab2 = new Tableau(3);
        Tableau Tab3 = new Tableau(5);
        int[][] Mat = new int[][]{Tab1.getTablo(), Tab2.getTablo(), Tab3.getTablo()};
        Matrice MatTest = new Matrice(Mat);
        System.out.println("Création d'une matrice à partir de ce tableau : ");
        System.out.println(Arrays.deepToString(Mat) + "\n");
        System.out.println(MatTest.toString());

        MaMatrice.MutipleTo(MatSym);
        System.out.println("Multiplication des deux premières matrices : ");
        System.out.println(MaMatrice.toString());

        System.out.println("Multiplication de la première matrice 5x5 et de la troisième 3x5 : ");
        Matrice MatMultiple = Multiplication(MaMatrice, MatTest);
        System.out.println(MatMultiple.toString());

        /*
        int[][] tablotest = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] tablocopie = Arrays.copyOf(tablotest, tablotest.length);

        System.out.println(Arrays.deepToString(tablotest));
        System.out.println(Arrays.deepToString(tablocopie));

        //int i = 2, j = 12;
        //boolean isTest = Arrays.deepEquals(tablotest, tablocopie);
        //System.out.println(i + " " + j );
        //System.out.println(Arrays.deepToString(tablotest));
        //System.out.println(Arrays.deepToString(tablocopie));
        */
    }
}
