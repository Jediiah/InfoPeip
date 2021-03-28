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
	protected String NomClasse;
	
	public String toString() {
		String ReturnString;

		ReturnString = this.NomClasse + "\n" +
						"VieMax      = " + this.VieMax + "\n" +
						"Degats      = " + this.Degats + "\n" +
						"Hydratation = " + this.Hydratation + "\n" +
						"Esquive     = " + this.Esquive + "\n" +
						"LieuPreféré = " + this.LieuPrefere + "\n";

		ReturnString += "Vous êtes actuellement à : " + this.LieuActuel + "\n" +
						"La météo est : " + this.Meteo + "\n";
		
		return(ReturnString);
	}

	public void SubirAttaque(Personnage attaquant) {
		double Multiplicateur = Math.random();
		if(Multiplicateur<0.2); Multiplicateur = 0.2;
		int DegatRecus = (int)(attaquant.Degats * Multiplicateur);
		if (DegatRecus < 0) {
			DegatRecus = 0;
		}
		this.VieActuel = this.VieActuel - DegatRecus;
		System.out.println("L'attaque inflige "+DegatRecus+" dégat(s) !");	
	}
	
	public void EsquiverAttaque(Personnage attaquant) {
		int Test = (int)(Math.random() * 99);
		if (Test >= this.Esquive) {
			this.SubirAttaque(attaquant);
		}
		else {
			System.out.println("L'attaque est esquivée !");
		}
	}

	public void Boire(double TauxAlcoolBoisson) {
		System.out.println("TauxAlcool +" + TauxAlcoolBoisson + ", Hydratation augmentée et Esquive diminuée.");
		this.TauxAlcool += TauxAlcoolBoisson;
		this.Hydratation = (int)(this.Hydratation * (1 + TauxAlcoolBoisson));
		if (this.Hydratation > 100); this.Hydratation = 100;
		this.Esquive = (int)(this.Esquive * (1 - TauxAlcoolBoisson));
	}

	public void ChgmtLieu(String LieuSuivant) {
		System.out.println("Le concert suivant est à la scnène " + LieuSuivant);
		this.LieuActuel = LieuSuivant;
		if(this.LieuActuel.equals(this.LieuPrefere)) {
			System.out.println("C'est votre scène préférée, la météo n'a plus aucun effet sur vous.");
			this.ChgmtMeteo("Normale");
		}
		// On actualise les buffs s'il pleu et qu'on arrive dans un lieu couvert
		else if (this.Meteo.equals("Pluie") && this.IsCouvert(LieuSuivant)) {
			System.out.println("Par chance c'est un lieu couvert, la pluie n'a plus d'effets.");
			this.ChgmtMeteo("Normale");
		}
	}

	public void ChgmtMeteo(String MeteoSuivante) {
		//System.out.println("Breaking News : la météo est maintenant " + MeteoSuivante);
		this.CalculBuff(this.Meteo, MeteoSuivante);
		this.Meteo = MeteoSuivante;
	}

	private void CalculBuff(String MeteoActuelle, String MeteoSuivante) {
		if(MeteoActuelle.equals("Normale")) {
			if(MeteoSuivante.equals("Pluie")) {
				System.out.println("Il s'est mis à pleuvoir ; Esquive -90%");
				this.Esquive = (int)(this.Esquive * 0.1);
			}
			else if(MeteoSuivante.equals("Canicule")) {
				System.out.println("C'est la canicicule aujourd'hui : TauxAlcool +40% et Hydratation -20%");
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
				System.out.println("La température à baissée : TauxAlcool -20%");
				this.TauxAlcool *= 0.8;
			}
		}
		else if(MeteoActuelle.equals("Pluie")) {
			if(MeteoSuivante.equals("Canicule")) {
				this.CalculBuff(MeteoActuelle, "Normale");
				this.CalculBuff("Normale", MeteoSuivante);
			}
			else if(MeteoSuivante.equals("Normale")) {
				System.out.println("Il s'est arrêté de pleuvoir ; Esquive +60%");
				this.Esquive = (int)(this.Esquive * 1.6);
			}
		}
	}

	public void AugmenteVieMax(int MontantAugmentation) {
		this.VieMax += MontantAugmentation;
	}

	public void AugmenteVie(int MontantAugmentation) {
		this.VieActuel += MontantAugmentation;
		if(this.VieActuel > this.VieMax); this.VieActuel = this.VieMax;
	}

	public void AugmenteHydrate(int MontantAugmentation) {
		this.Hydratation += MontantAugmentation;
	}

	public void Dormir() {
		System.out.println("C'est la fin de la journée vous pouvez enfin vous reposer quelque heures." + "\n" + 
							"Votre taux d'alcool est divisé par 2 et vous gagnez 20 de vie.");
		this.TauxAlcool *= 0.5;
		this.AugmenteVie(20);
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

	public int getVieActuel() {
		return(this.VieActuel);
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

	public String getNomClasse() {
		return(this.NomClasse);
	}
	
	public boolean isAlive() {
		if (this.VieActuel < 1 || this.TauxAlcool > 1 || this.Hydratation < 1) {
			return false;
		}
		return true;
	}

}