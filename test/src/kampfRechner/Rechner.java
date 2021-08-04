package kampfRechner;

public class Rechner {

	private Held angreifer;
	private Held verteidiger;
	private double angreiferGesamtLeben;
	private double verteidigerGesamtLeben;
	private int runden;

	private KampfProtokoll protokoll;

	public Rechner(Held angreifer, Held verteidiger) {
		this.angreifer = angreifer;
		this.verteidiger = verteidiger;
	}

	public String kampf() {

		this.initRunde(angreifer, verteidiger);
		double angreiferBeginLeben = angreiferGesamtLeben;
		double verteidigerBeginLeben = verteidigerGesamtLeben;

		
		speciaCaseFirstRound(angreifer, verteidiger, angreiferBeginLeben, verteidigerBeginLeben);
			
		
		
		while (runden < 100) {
			if (angreiferGesamtLeben * 1.0 / angreiferBeginLeben < 0.3)
				return "Angreifer verliert! " + runden;
			else if (verteidigerGesamtLeben * 1.0 / verteidigerBeginLeben < 0.3)
				return "Angreifer gewinnt! " + runden;
			else
				this.eineRunde(angreifer, verteidiger);
		}
		return "100 Runden erreicht! Angreifer verliert automatisch!";
	}

	
	
	private void initRunde(Held atter, Held deffer) {

		
		
		protokoll = new KampfProtokoll();
		angreiferGesamtLeben = rechneGesamtLeben(atter);
		verteidigerGesamtLeben = rechneGesamtLeben(deffer);
		runden = 0;
	}

	private long rechneGesamtLeben(Held zuRechnen) {

		long gesamt = 0;
		double[] horde = zuRechnen.getHorde();

		for (int position = 0; position < horde.length; position++) {
			double toAdd = horde[position] * zuRechnen.getLebensBoni() * Wesen.getEinheitenLeben(position);

			if (position == 1) // Sonderregel für EHW!
				toAdd *= 0.1;
			gesamt += (long) toAdd;
		}
		return gesamt;
	}
	
	private void speciaCaseFirstRound(Held atter, Held deffer, double angreiferBeginLeben,
			double verteidigerBeginLeben) {

		double altesLebenAtter = angreiferGesamtLeben;
		double altesLebenDeffer = verteidigerGesamtLeben;
		Held neuerAtter = new Held(atter.getAngriff(),atter.getVerteidigung(),atter.getLeben());
		neuerAtter.setBoni(atter.getAngriffsBoni(), atter.getVerteidigungsBoni(), atter.getLebensBoni());
		neuerAtter.setHorde(atter.getHorde());
		
		Held neuerDeffer = new Held(deffer.getAngriff(),deffer.getVerteidigung(),deffer.getLeben());
		neuerDeffer.setBoni(deffer.getAngriffsBoni(), deffer.getVerteidigungsBoni(), deffer.getLebensBoni());
		neuerDeffer.setHorde(deffer.getHorde());
		
		neuerDeffer.addVerteidigungsBoni(20);
		this.eineRunde(neuerAtter, neuerDeffer);

		if (angreiferGesamtLeben * 1.0 / angreiferBeginLeben < 0.3
				|| verteidigerGesamtLeben * 1.0 / verteidigerBeginLeben < 0.3) {
			angreifer.setHorde(neuerAtter.getHorde());
			verteidiger.setHorde(neuerDeffer.getHorde());
			return ;
		}
			

		angreiferGesamtLeben = altesLebenAtter;
		verteidigerGesamtLeben = altesLebenDeffer;
	}
	
	

	public void eineRunde(Held atter, Held deffer) {

		double[] atterHorde = atter.getHorde();
		double[] defferHorde = deffer.getHorde();
		double[] oldAtterHorde = atter.getHorde();
		double[] oldDefferHorde = deffer.getHorde();

		double[] att = new double[atterHorde.length];
		for (int addAtt = 0; addAtt < atterHorde.length; addAtt++)
			att[addAtt] = Wesen.getEinheitenAngriff(addAtt) * atterHorde[addAtt];

		double[] deff = new double[defferHorde.length];
		for (int addDeff = 0; addDeff < atterHorde.length; addDeff++)
			deff[addDeff] = Wesen.getEinheitenVerteidigung(addDeff) * defferHorde[addDeff];

		double[] neuesLebenAtter = schadenAusrechnen(deff, atterHorde, atter, deffer.getVerteidigungsBoni());
		atter.setHorde(this.aktualisiereHorde(atter, neuesLebenAtter, true));
		angreiferGesamtLeben = HelferMethoden.sum(neuesLebenAtter);

		double[] neuesLebenDeffer = schadenAusrechnen(att, defferHorde, deffer, atter.getAngriffsBoni());
		deffer.setHorde(this.aktualisiereHorde(deffer, neuesLebenDeffer, false));
		verteidigerGesamtLeben = HelferMethoden.sum(neuesLebenDeffer);
		runden++;

		protokoll.addRunde(oldAtterHorde, atterHorde, oldDefferHorde, defferHorde, runden);
	}



	public double[] schadenAusrechnen(double[] schaden, double[] horde, Held deffer, double angriffsBonus) {

		double[] leben = new double[horde.length];
		long gesamtLeben = 0;

		for (int addLeben = 0; addLeben < horde.length; addLeben++) {

			double bonus = deffer.getLebensBoni();
			leben[addLeben] = (horde[addLeben] * bonus * Wesen.getEinheitenLeben(addLeben));
			gesamtLeben += leben[addLeben];
		}

		double[] defferHorde = deffer.getHorde();

		for (int einheit = 0; einheit < 17; einheit++) {

			if (leben[einheit] > 0 && defferHorde[einheit] > 0) {

				double anteil = ((double) leben[einheit]) / gesamtLeben;

				for (int schadensEinheit = 0; schadensEinheit < 17; schadensEinheit++) {
					if (schaden[schadensEinheit] != 0) {
						double att = schaden[schadensEinheit];
						att *= Wesen.hatBonus(schadensEinheit, einheit);
						att *= angriffsBonus;
						att *= anteil;
						leben[einheit] -= att; // Einheitenboni
						// einrechnen!!
					}
				}
			}

		}
		return leben;
	}

	public double[] aktualisiereHorde(Held aktualisierter, double[] neuesLeben, boolean angreifer) {

		double lebensBoni = aktualisierter.getLebensBoni();

		double[] horde = aktualisierter.getHorde();
		double[] neueHorde = new double[horde.length];

		for (int i = 0; i < 17; i++) {

			neueHorde[i] = ((neuesLeben[i] / lebensBoni) / Wesen.getEinheitenLeben(i));

		}
		return neueHorde;
	}

	public long[] getAtterHorde() {
		return HelferMethoden.roundAndCut(angreifer.getHorde());
	}

	public long[] getDeffHorde() {
		return HelferMethoden.roundAndCut(verteidiger.getHorde());
	}

}
