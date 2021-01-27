package tp_jdr.Personnage;

public interface PersonnageIntf {

	//Subit des degats de la part d'un autre personnage
	public void SubirAttaque(Personnage attaquant);
	
	//Essaye d'esquiver l'attaque d'un autre personnage
	public void EsquiverAttaque(Personnage attaquant);
	
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