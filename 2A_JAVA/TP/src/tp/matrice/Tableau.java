package tp.matrice; // Pas ça mais le reste

import java.util.stream.IntStream;

public class Tableau {
    
    private int[] Tablo;

    public String toString() {
        String ReturnString = "";
        for (int i: this.Tablo) {
            ReturnString += i + " ";
        }

        return(ReturnString);
    }

    public int MaxNb() {
        int Max = 0;
        for (int i: this.Tablo) {
            if (i > Max) {
                Max = i;
            }
        }
        return(Max);
    }

    public int[] getTablo() {
        return(this.Tablo);
    }

    public Tableau(int lenght) {
        this.Tablo = IntStream.generate(() -> {return (int)(Math.random() * 10000); }).limit(lenght).toArray();
    }

}