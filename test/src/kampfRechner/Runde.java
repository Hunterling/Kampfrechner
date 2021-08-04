package kampfRechner;

public class Runde {

	
	private double[]	verlusteAtter;
	private double[]	verbleibendAtter;
	private double[]	verlusteDeffer;
	private double[]	verbleibendDeffer;
	private int			runde;
	
	public Runde(double[] verlusteAtter, double[] verbleibendAtter, double[] verlusteDeffer, double[] verbleibendDeffer, int runde) {
		
		this.verlusteAtter = verlusteAtter;
		this.verbleibendAtter =verbleibendAtter;
		this.verlusteDeffer = verlusteDeffer;
		this.verbleibendDeffer = verbleibendDeffer;
		this.runde = runde; 
	}

	public double[] getVerlusteAtter() {
		return verlusteAtter;
	}

	public double[] getVerbleibendAtter() {
		return verbleibendAtter;
	}

	public double[] getVerlusteDeffer() {
		return verlusteDeffer;
	}

	public double[] getVerbleibendDeffer() {
		return verbleibendDeffer;
	}

	public int getRunde() {
		return runde;
	}


	
}
