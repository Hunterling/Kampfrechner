package main;

import kampfRechner.Held;
import kampfRechner.Rechner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Held atter = new Held(0, 0, 0);
		
		//long[] atterHorde = new long[] {0,1_486_585,76_110,142_260,815_825,726_551,229_070,179_141,1_848,96_255,0,0,0,0,0,0,0};
		//long[] atterHorde = new long[] {0,145611,110436,82327,463741,557562,0,129577,609034,29235,14398,429473,0,6138,59055,0,0};
		//double[] atterHorde = new double[] {0,0,76110,142260,815825,726551,229070,179141,1848,96255,0,0,0,0,0,0,0};
		double[] atterHorde = {0,0,25000,25000,25000,0,0,0,0,0,0,0,0,0,0,0,0};
		atter.setHorde(atterHorde);
		//atter.setAngriff(0);
		//atter.setLeben(0);
		
		Held deffer = new Held(0, 0, 0);
		double[] defferHorde = new double[] {0,0,83590,71712,142511,35539,215713,0,0,0,111648,0,0,0,0,0,0};
		deffer.setHorde(defferHorde);
		//deffer.setLeben(60);
		//deffer.setBoni(0, 47.5, 16.5);
		
		Rechner rechner = new Rechner(atter, deffer);
		rechner.kampf();
		//rechner.printVerluste();
		
		
		
		// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	}

	
	
	

}
