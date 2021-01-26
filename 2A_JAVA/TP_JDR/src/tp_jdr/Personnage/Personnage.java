package tp_jdr.Personnage;

public abstract class Personnage implements PersonnageIntf {
	protected int VieMax;
	protected int VieActuel;
	protected int Degats;
	protected int Hydratation;
	protected int TauxAlcool;
	protected int Esquive;
	
	public void SubirAttaque(Personnage attaquant) {
		int DegatRecus = attaquant.Degats;
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

	public void Boire(int TauxAlcoolBoisson) {
		this.TauxAlcool += TauxAlcoolBoisson;
		this.Hydratation *= 1 + TauxAlcoolBoisson;
		if (this.Hydratation > 100); this.Hydratation = 100;
		this.Esquive *= 1 - TauxAlcoolBoisson;
	}
	
	public int getVieMax() {
		return this.VieMax;
	}
	
	public int getDegats() {
		return this.Degats;
	}
	
	public int getHydratation() {
		return this.Hydratation;
	}
	
	public int getTauxAlcool() {
		return this.TauxAlcool;
	}
	
	public int getEsquive() {
		return this.Esquive;
	}
	
	public boolean isAlive() {
		if (this.VieActuel < 1 || this.TauxAlcool > 1) {
			return false;
		}
		return true;
	}

}