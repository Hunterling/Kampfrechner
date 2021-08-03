package manaproduktion;

public class Baum {

	private int stufe;
	private int produktion;
	
	public Baum(int stufe) {
		this.stufe = stufe;
		produktion = (int) Math.ceil(Math.pow(stufe, 1.1));		
	}

	public int getStufe() {
		return stufe;
	}

	public void setStufe(int stufe) {
		this.stufe = stufe;
	}

	public int getProduktion() {
		return produktion;
	}

	public void setProduktion(int produktion) {
		this.produktion = produktion;
	}
	
	
}
