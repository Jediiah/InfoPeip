package tp_jdr.Personnage;

public abstract class Personnage implements PersonnageIntf {
	protected int VieMax;
	protected int VieActuel;
	protected int Degats;
	protected int Hydratation;
	protected double TauxAlcool;
	protected int Esquive;
	protected String LieuPrefere;
	protected String LieuActuel;
	protected String Meteo;
	protected double BuffEnvironnement;
	
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

	public void Boire(double TauxAlcoolBoisson) {
		this.TauxAlcool += TauxAlcoolBoisson;
		this.Hydratation = (int)(this.Hydratation * (1 + TauxAlcoolBoisson));
		if (this.Hydratation > 100); this.Hydratation = 100;
		this.Esquive = (int)(this.Esquive * (1 - TauxAlcoolBoisson));
	}

	public void ChgmtLieu(String LieuSuivant) {
		this.LieuActuel = LieuSuivant;
		if(this.LieuActuel.equals(this.LieuPrefere)) {
			this.ChgmtMeteo("Normale");
		}
		// On actualise les buffs s'il pleu et qu'on arrive dans un lieu couvert
		else if (this.Meteo.equals("Pluie") && this.IsCouvert(LieuSuivant)) {
			this.ChgmtMeteo("Normale");
		}
	}

	public void ChgmtMeteo(String MeteoSuivante) {
		this.CalculBuff(this.Meteo, MeteoSuivante);
		this.Meteo = MeteoSuivante;
	}

	private void CalculBuff(String MeteoActuelle, String MeteoSuivante) {
		if(MeteoActuelle.equals("Normale")) {
			if(MeteoSuivante.equals("Pluie")) {
				this.Esquive = (int)(this.Esquive * 0.1);
			}
			else if(MeteoSuivante.equals("Canicule")) {
				this.TauxAlcool *= 1.4;
				this.Hydratation = (int)(this.Hydratation * 0.8);
			}
		}
		else if(MeteoActuelle.equals("Canicule")) {
			if(MeteoSuivante.equals("Pluie")) {
				this.CalculBuff(MeteoActuelle, "Normale");
				this.CalculBuff("Normale", MeteoSuivante);
			}
			else if(MeteoSuivante.equals("Normale")) {
				this.TauxAlcool *= 0.8;
			}
		}
		else if(MeteoActuelle.equals("Pluie")) {
			if(MeteoSuivante.equals("Canicule")) {
				this.CalculBuff(MeteoActuelle, "Normale");
				this.CalculBuff("Normale", MeteoSuivante);
			}
			else if(MeteoSuivante.equals("Normale")) {
				this.Esquive = (int)(this.Esquive * 1.6);
			}
		}
	}

	public void Heal(int MontantHeal) {
		this.VieActuel += MontantHeal;
		if(this.VieActuel > this.VieMax); this.VieActuel = this.VieMax;
	}

	public void AugmenteVieMax(int MontantAugmentation) {
		this.VieMax += MontantAugmentation;
	}

	public void AugmenteVie(int MontantAugmentation) {
		this.VieActuel += MontantAugmentation;
	}

	public void AugmenteHydrate(int MontantAugmentation) {
		this.Hydratation += MontantAugmentation;
	}

	public void Dormir() {
		this.TauxAlcool *= 0.5;
		this.Heal(20);
	}
	
	public boolean IsCouvert(String Lieu) {
		if (Lieu.equals("Temple") || Lieu.equals("Altar") || Lieu.equals("Valley")) {
			return(true);
		}
		return(false);
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
	
	public double getTauxAlcool() {
		return this.TauxAlcool;
	}
	
	public int getEsquive() {
		return this.Esquive;
	}

	public String getMeteo() {
		return(this.Meteo);
	}
	
	public boolean isAlive() {
		if (this.VieActuel < 1 || this.TauxAlcool > 1 || this.Hydratation < 1) {
			return false;
		}
		return true;
	}

}