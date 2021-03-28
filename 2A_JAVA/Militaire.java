public class Militaire {
    private String nom;
    private String grade;
    private Militaire superieur;

    Militaire(String nom, String grade, Militaire superieur){
        this.nom = nom;
        this.grade = grade;
        this.superieur = superieur;
    }

    Militaire(String nom, String grade){
        this.nom = nom;
        this.grade = grade;
        this.superieur = null;
    }

    public String toString() {
        if(this.superieur == null) {
            return(this.grade + " " + this.nom);
        }
        //return("Name : " + this.nom + " ---> Superieur" + this.superieur.toString());
        return(this.superieur.toString() + '\n' + "|\n" + this.grade + " " + this.nom);
    }

    public String getNom(){
        return this.nom;
    }

    public Militaire getSuperieur(){
        return this.superieur;
    }

    public static void main(String[] args) {
        Militaire mil=new Militaire("Foch", "General");
        // dessin 1
        mil = new Militaire("Fayolle", "Colonel", mil);
        // dessin 2
        Militaire mil2 = new Militaire("Durand", "Lieutenant", mil);
        // dessin 3
        mil = new Militaire("Chapuis", "Lieutenant", mil);
        // dessin 4

        System.out.println(mil.toString());
        System.out.println(" ");
        System.out.println(mil2.toString());
    }
}
