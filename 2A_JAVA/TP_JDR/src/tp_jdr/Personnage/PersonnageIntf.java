package tp_jdr.Personnage;

public interface PersonnageIntf {

	//Subit des degats de la part d'un autre personnage
	public void SubirAttaque(Personnage attaquant);
	
	//Essaye d'esquiver l'attaque d'un autre personnage
	public void EsquiverAttaque(Personnage attaquant);
	
	//Retourne la vie d'un personnage 
	public int getVie();
	
	//Retourne les degats infliges par un personnage
	public int getDegats();
	
	//Retourne l'armure d'un personnage 
	public int getArmure();
	
	//Retourne l'esquive d'un personnage en %
	public int getEsquive();
	
	//Retourne True si le personnage est vivant
	public boolean isAlive();
}