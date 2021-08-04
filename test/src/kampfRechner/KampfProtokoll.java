package kampfRechner;

import java.util.LinkedList;

public class KampfProtokoll {

	private LinkedList<Runde> kampf;
	
	
	public KampfProtokoll() {
		kampf = new LinkedList<Runde>();
	}
	
	public void addRunde(Runde toAdd) {
		kampf.add(toAdd);
	}
	
	public void addRunde(double[] attStart, double[] attEnde, double[] deffStart, double[] deffEnde, int runde) {
		
		double[] atterVerluste = new double[attStart.length];
		double[] defferVerluste = new double[deffStart.length];
		
		for(int count = 0; count < attStart.length;count++) {
			atterVerluste[count] = attStart[count] - attEnde[count];
			defferVerluste[count] = deffStart[count] - deffEnde[count];
			
		}
		
		Runde r = new Runde(atterVerluste, attEnde, defferVerluste, deffEnde, runde);
		kampf.add(r);
	}
	
}
