package tp_jdr.Plateau;

public abstract class Evenement implements EvenementIntf {
    protected String Contenu;
    protected Evenement Suite;
    protected boolean Final=false;

    public String getContenu() {
        return(this.Contenu);
    }

    public Evenement getSuite() {
        return(this.Suite);
    }
}
