package tp.matrice;

import java.util.Arrays;

public class MatriceSymetrique extends Matrice {
    
    public MatriceSymetrique(int Taille) {
        super(Taille);
        int[][] MatResult = new int[this.Size[1]][this.Size[0]];
        for (int i=0; i<this.Size[0]; i++){
            for (int j=i; j<this.Size[1]; j++) {
                MatResult[i][j] = this.Matrice[i][j];
                MatResult[j][i] = this.Matrice[i][j];
            }
        }
        this.Matrice = MatResult;
    }

    public MatriceSymetrique(int[][] Matrice) {
        super(Matrice);
        int[][] MatResult = new int[this.Size[1]][this.Size[0]];
        for (int i=0; i<this.Size[0]; i++){
            for (int j=i; j<this.Size[1]; j++) {
                MatResult[i][j] = this.Matrice[i][j];
                MatResult[j][i] = this.Matrice[i][j];
            }
        }
        this.Matrice = MatResult;
    }

    @Override
    public boolean isSymetrique() {
        return(true);
    }

}
