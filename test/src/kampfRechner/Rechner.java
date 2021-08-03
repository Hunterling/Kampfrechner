package kampfRechner;

import java.util.LinkedList;

public class Rechner {

	private Held angreifer;
	private Held verteidiger;
	private long angreiferBeginLeben;
	private long angreiferGesamtLeben;
	private long verteidigerBeginLeben;
	private long verteidigerGesamtLeben;
	private int vorbei;
	private Prints printer;
	private int runden;
	private LinkedList<double[]> verlusteAngreifer;
	private LinkedList<double[]> verlusteVerteidiger;


	public Rechner(Held angreifer, Held verteidiger) {
		verlusteAngreifer = new LinkedList<double[]>();
		verlusteVerteidiger = new LinkedList<double[]>();
		vorbei = 0;
		this.angreifer = angreifer;
		this.verteidiger = verteidiger;
		printer = new Prints();
		// attGesamtVerluste = angreifer.getHorde();
		// deffGesamtVerluste = verteidiger.getHorde();
	}

	public String kampf() {
		this.start(angreifer, verteidiger);
		String ausgang = "";

		while (vorbei == 0) {
			if (angreiferGesamtLeben * 1.0 / angreiferBeginLeben < 0.3) {
				ausgang += "Angreifer verliert! " + runden;
				vorbei += 2;
			} else if (verteidigerGesamtLeben * 1.0 / verteidigerBeginLeben < 0.3) {
				ausgang += "Angreifer gewinnt! " + runden;
				vorbei -= 1;
			} else {
				this.eineRunde(angreifer, verteidiger);
			}

		}
		return ausgang;
	}

//	private void summiereVerluste() {
//		double[] attHorde = angreifer.getHorde();
//		double[] deffHorde = verteidiger.getHorde();
//
//		for (int att = 0; att < attHorde.length; att++) {
//			attGesamtVerluste[att] = (long) (attGesamtVerluste[att] - attHorde[att]);
//		}
//		for (int deff = 0; deff < deffHorde.length; deff++) {
//			deffGesamtVerluste[deff] = (long) (deffGesamtVerluste[deff] - deffHorde[deff]);
//		}
//	}

	public void start(Held atter, Held deffer) {

		angreiferBeginLeben = rechneGesamtLeben(atter);
		angreiferGesamtLeben = angreiferBeginLeben;
		verteidigerBeginLeben = rechneGesamtLeben(deffer);
		verteidigerGesamtLeben = verteidigerBeginLeben;
		
		double[] EHW = angreifer.getHorde();
		EHW[1]*= 0.1;
		angreifer.setHorde(EHW);
		
		EHW =verteidiger.getHorde();
		EHW[1]*= 0.1;
		verteidiger.setHorde(EHW);
		
		// deffer.addVerteidigungsBoni(20);

		runden = 0;
	}

	private long rechneGesamtLeben(Held zuRechnen) {
		long gesamt = 0;
		double[] horde = zuRechnen.getHorde();

		for (int position = 0; position < horde.length; position++) {
			double toAdd = horde[position] * zuRechnen.getLebensBoni() * Wesen.getEinheitenLeben(position);

			if (position == 1)
				toAdd *= 0.1;
			gesamt += (long) toAdd;

		}
		return gesamt;
	}

	public void eineRunde(Held atter, Held deffer) {

		double[] atterHorde = atter.getHorde();
		double[] defferHorde = deffer.getHorde();

		double[] att = new double[atterHorde.length];

		for (int addAtt = 0; addAtt < atterHorde.length; addAtt++) {
			double bonus = atter.getAngriffsBoni();
			bonus *= Wesen.getEinheitenAngriff(addAtt);
			bonus *= atterHorde[addAtt];
			att[addAtt] = bonus;
		}
		double[] deff = new double[defferHorde.length];

		for (int addDeff = 0; addDeff < defferHorde.length; addDeff++) {
			deff[addDeff] = (defferHorde[addDeff] * deffer.getVerteidigungsBoni()
					* Wesen.getEinheitenVerteidigung(addDeff));
		}

		double[] neuesLebenAtter = schadenAusrechnen(deff, atterHorde, atter);
		atter.setHorde(this.aktualisiereHorde(atter, neuesLebenAtter, true));
		double[] neuesLebenDeffer = schadenAusrechnen(att, defferHorde, deffer);
		deffer.setHorde(this.aktualisiereHorde(deffer, neuesLebenDeffer, false));

		angreiferGesamtLeben = (long) this.sum(neuesLebenAtter);
		verteidigerGesamtLeben = (long) this.sum(neuesLebenDeffer);

		runden++;
	}

	public double[] schadenAusrechnen(double[] schaden, double[] horde, Held deffer) {

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
						leben[einheit] -= (anteil * schaden[schadensEinheit]
								* Wesen.hatBonus(schadensEinheit, einheit)); // Einheitenboni
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
		double[] verluste = new double[horde.length];
		for (int i = 0; i < 17; i++) {

			neueHorde[i] = ((neuesLeben[i] / lebensBoni) / Wesen.getEinheitenLeben(i));
			verluste[i] = horde[i] - neueHorde[i];
		}

		if (angreifer) {
			verluste[0] = angreiferGesamtLeben;
			verlusteAngreifer.add(verluste);
		}

		else {
			verluste[0] = verteidigerGesamtLeben;
			verlusteVerteidiger.add(verluste);
		}

		// printer.printHorde("abd", verluste, angreiferGesamtLeben);
		return neueHorde;
	}

	private double sum(double[] sumUp) {
		double sum = 0;
		for (double toAdd : sumUp)
			sum += toAdd;
		return sum;
	}

	public void printVerluste() {
		System.out.println("\n\n\n AUSGABE VERLUSTE");
		for (double[] runden : verlusteAngreifer) {
			printer.printHorde("Angreifer", runden, runden[0]);
		}

		for (double[] runden : verlusteVerteidiger) {
			printer.printHorde("Verteidiger", runden, runden[0]);
		}
	}

	public long[] getAtterHorde() {
		return this.roundAndCut(angreifer.getHorde());
	}

	public long[] getDeffHorde() {
		return this.roundAndCut(verteidiger.getHorde());
	}

	private long[] roundAndCut(double[] toRound) {
		long[] newArray = new long[toRound.length];

		for (int count = 0; count < toRound.length; count++) {
			newArray[count] = Math.round(toRound[count]);

		}
		return newArray;
	}
}
