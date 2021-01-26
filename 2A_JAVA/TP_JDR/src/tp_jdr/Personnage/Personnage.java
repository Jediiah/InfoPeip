package tp_jdr.Personnage;

public abstract class Personnage implements PersonnageIntf {
	protected int Vie;
	protected int VieActuel;
	protected int Degats;
	//protected int Tranchant;
	protected String NomDeLaClasse;
	//protected int Feu;
	//protected int Foudre;
	//protected int Brisearmure;
	//protected int Saignement;
	//protected int Malediction;
	protected int Armure;
	protected int Esquive;
	
	public void SubirAttaque(Personnage attaquant) {
		int DegatRecus = attaquant.Degats - this.Armure;
		if (DegatRecus < 0) {
			DegatRecus = 0;
		}
		this.VieActuel = this.VieActuel - DegatRecus;
		System.out.println("L'attaque inflige "+DegatRecus+" dégat(s) !");	
	}
	
	public void EsquiverAttaque(Personnage attaquant) {
		int Test = (int)(Math.random() * 99);
		if (Test >= this.Esquive) {
			this.VieActuel = this.VieActuel - attaquant.Degats;
		}
		else {
			System.out.println("L'attaque est esquivée !");
		}
	}
	
	public int getVie() {
		return this.Vie;
	}
	
	public int getDegats() {
		return this.Degats;
	}
	
	public int getArmure() {
		return this.Armure;
	}
	
	public int getEsquive() {
		return this.Esquive;
	}
	
	public boolean isAlive() {
		if (this.VieActuel < 1) {
			return false;
		}
		return true;
	}

}