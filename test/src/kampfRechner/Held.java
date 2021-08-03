package kampfRechner;

public class Held {

	private int leben;
	private int verteidigung;
	private int angriff;
	//private int geschwindigkeit;
	//private long hordenPunkte;
	private double angriffsBoni;
	private double verteidigungsBoni;
	private double lebensBoni;



	private double[] horde;

	private Wesen wesen;

	public Held(int angriff, int verteidigung, int leben) {



		this.angriff = angriff;
		this.verteidigung = verteidigung;
		this.leben = leben;

		this.angriffsBoni = 1;
		this.verteidigungsBoni = 1;
		this.lebensBoni = 1;

		horde = new double[17];
		wesen = new Wesen();
	}

//	private long rechneHordenPunkte() {
//		for (int i = 0; i < 17; i++) {
//			hordenPunkte += Wesen.getEinheitenPunkte(i) * horde[i];
//		}
//		return hordenPunkte;
//	}





	public boolean setBoni(double angriff, double verteidigung, double leben) {

		angriffsBoni = angriff;
		verteidigungsBoni = verteidigung;
		lebensBoni = leben;

		return true;
	}

	public int getLeben() {
		return leben;
	}

	public void setLeben(int leben) {
		this.leben = leben;
	}

	public int getVerteidigung() {
		return verteidigung;
	}

	public void setVerteidigung(int verteidigung) {
		this.verteidigung = verteidigung;
	}

	public int getAngriff() {
		return angriff;
	}

	public void setAngriff(int angriff) {
		this.angriff = angriff;
	}

//	public int getGeschwindigkeit() {
//		return geschwindigkeit;
//	}
//
//	public void setGeschwindigkeit(int geschwindigkeit) {
//		this.geschwindigkeit = geschwindigkeit;
//	}

//	public long getHordenPunkte() {
//		return hordenPunkte;
//	}
//
//	public void setHordenPunkte(long hordenPunkte) {
//		this.hordenPunkte = hordenPunkte;
//	}

	public void addAngriffsBoni(double toAdd) {
		angriffsBoni += toAdd/100;
	}
	
public void addVerteidigungsBoni(double toAdd) {
		verteidigungsBoni += toAdd/100;
	}

public void addLebensBoni(double toAdd) {
	lebensBoni += toAdd/100;
}
	
	public double getAngriffsBoni() {		
		return angriffsBoni+ angriff*0.01;
	}

	public void setAngriffsBoniPercent(double angriffsBoni) {
		this.angriffsBoni = angriffsBoni/100 +1;
	}

	public double getVerteidigungsBoni() {
		return verteidigungsBoni + verteidigung *0.012;
	}

	public void setVerteidigungsBoniPercent(double verteidigungsBoni) {
		this.verteidigungsBoni = verteidigungsBoni/100 + 1;
	}

	public double getLebensBoni() {
		return lebensBoni + leben*0.0075;
	}

	public void setLebensBoniPercent(double lebensBoni) {
		this.lebensBoni = lebensBoni;
	}

//	public long[] getWesenAngriff() {
//		return wesenAngriff;
//	}
//
//	public void setWesenAngriff(long[] wesenAngriff) {
//		this.wesenAngriff = wesenAngriff;
//	}
//
//	public long getGesamtAngriff() {
//		return gesamtAngriff;
//	}
//
//	public void setGesamtAngriff(long gesamtAngriff) {
//		this.gesamtAngriff = gesamtAngriff;
//	}
//
//	public long[] getWesenVerteidigung() {
//		return wesenVerteidigung;
//	}
//
//	public void setWesenVerteidigung(long[] wesenVerteidigung) {
//		this.wesenVerteidigung = wesenVerteidigung;
//	}
//
//	public long getGesamtVerteidigung() {
//		return gesamtVerteidigung;
//	}
//
//	public void setGesamtVerteidigung(long gesamtVerteidigung) {
//		this.gesamtVerteidigung = gesamtVerteidigung;
//	}
//
//	public long[] getWesenLeben() {
//		return wesenLeben;
//	}
//
//	public void setWesenLeben(long[] wesenLeben) {
//		this.wesenLeben = wesenLeben;
//	}
//
//	public long getGesamtLeben() {
//		return gesamtLeben;
//	}
//
//	public void setGesamtLeben(long gesamtLeben) {
//		this.gesamtLeben = gesamtLeben;
//	}

	public double[] getHorde() {
		return horde;
	}

	public void setHorde(double[] horde) {
		this.horde = horde;
	}

	public Wesen getWesen() {
		return wesen;
	}

	public void setWesen(Wesen wesen) {
		this.wesen = wesen;
	}

}
