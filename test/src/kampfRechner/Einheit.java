package kampfRechner;

public class Einheit {

	private final int leben;
	private final int angriff;
	private final int verteidigung;
	private final int kapazität;
	private final int punkte;
	private final int manakosten;
	private final int geschwindigkeit;
	private final String name;
	
	public Einheit(int angriff, int verteidigung,int leben, int kapazität, int punkte, int manakosten, int geschwindigkeit, String name) {
				
		this.leben = leben;
		this.angriff = angriff;
		this.verteidigung = verteidigung;
		this.kapazität = kapazität;
		this.punkte = punkte;
		this.manakosten = manakosten;
		this.geschwindigkeit = geschwindigkeit;
		this.name = name;
	}
	
	public int[] getKampfEinheit() {
		
		int retValue[] = {angriff,verteidigung,leben};
		return retValue;
	}
	
	public int getLeben() {
		return leben;
	}
	public int getAngriff() {
		return angriff;
	}
	public int getVerteidigung() {
		return verteidigung;
	}
	public int getKapazität() {
		return kapazität;
	}
	public int getPunkte() {
		return punkte;
	}
	public int getManakosten() {
		return manakosten;
	}
	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}
public String getName() {
	return name;
}
	
}
