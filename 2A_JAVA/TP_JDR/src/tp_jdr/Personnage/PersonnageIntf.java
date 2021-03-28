package tp_jdr.Personnage;

public interface PersonnageIntf {

	//Subit des degats de la part d'un autre personnage
	public void SubirAttaque(Personnage attaquant);
	
	//Essaye d'esquiver l'attaque d'un autre personnage
	public void EsquiverAttaque(Personnage attaquant);

	public void AugmenteVieMax(int MontantAugmentation);

	public void AugmenteVie(int MontantAugmentation);

	public void AugmenteHydrate(int MontantAugmentation);
	
	public void Dormir();

	public boolean IsCouvert(String Lieu);

	public int getHydratation();

	public double getTauxAlcool();

	public String getNomClasse();

	public int getVieActuel();

	//Retourne la vie d'un personnage 
	public int getVieMax();
	
	//Retourne les degats infliges par un personnage
	public int getDegats();
	
	//Retourne l'esquive d'un personnage en %
	public int getEsquive();

	public String getMeteo();
	
	//Retourne True si le personnage est vivant
	public boolean isAlive();
}