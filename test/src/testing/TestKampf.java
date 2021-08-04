package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import kampfRechner.*;

class TestKampf {

	private Wesen wesen;
	//private double atterHorde;
	//private double defferHorde;
	Held atter;
	Held deffer;
	private Rechner rechner;
	
	void initWesen() {
		wesen = new Wesen();
	}
	
	
	private void setUpNoHeroes(double[] atter, double[] deffer) {
		if(wesen == null) {
			this.initWesen();
		}
		this.initWesen();
		
		this.atter = new Held(0, 0, 0);
		this.deffer = new Held(0, 0, 0);
		
		this.atter.setHorde(atter);
		this.deffer.setHorde(deffer);
		
		this.rechner = new Rechner(this.atter, this.deffer);
	}
	
	@Test
	void test3gegen1KeinVorteil() {
		//this.initWesen();	
		double[] atterHorde = {0,0,25000,25000,25000,0,0,0,0,0,0,0,0,0,0,0,0};	
		double[] defferHorde = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};		
		defferHorde[13] = 2000;

		this.setUpNoHeroes(atterHorde, defferHorde);	
		rechner.kampf();

		
		long[] attHorde = rechner.getAtterHorde();
		long[] deffHorde = rechner.getDeffHorde();
		
		long[] resultAtt =	{0,0,22807,22807,22807 ,0,0,0,0,0,0,0,0,0,0,0,0};
						  //{0,0,0		,0	,0		,0,0,0,0,0,0,0,0,0,0,0,0}
		long[] resultDeff = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		resultDeff[13] = 179;
		assertEquals(equals(resultAtt,attHorde),true);
		assertEquals(equals(resultDeff,deffHorde),true);	
		// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	}
	
	@Test
	void test4gegen2KeinVorteil() {
		//this.initWesen();	
		double[] atterHorde = {0,0,25000,25000,25000,25000,0,0,0,0,0,0,0,0,0,0,0};	
		double[] defferHorde = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,4000,4000,0,0,0};		

		this.setUpNoHeroes(atterHorde, defferHorde);	
		rechner.kampf();

		
		long[] attHorde = rechner.getAtterHorde();
		long[] deffHorde = rechner.getDeffHorde();
		
		long[] resultAtt =	{0,0,16584,16584,16584,16584,0,0,0,0,0,0,0,0,0,0,0};
						  //{0,0,0		,0	,0		,0,0,0,0,0,0,0,0,0,0,0,0}
		long[] resultDeff = {0,0,0,0,0,0,0,0,0,0,0,0,712,712,0,0,0};
		assertEquals(equals(resultAtt,attHorde),true);
		assertEquals(equals(resultDeff,deffHorde),true);	
		// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	}
	
	@Test
	void test4gegen2KeinVorteil1Runde() {
		//this.initWesen();	
		double[] atterHorde = {0,0,25000,25000,25000,25000,0,0,0,0,0,0,0,0,0,0,0};	
		double[] defferHorde = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,1000,1000,0,0,0};		

		this.setUpNoHeroes(atterHorde, defferHorde);	
		rechner.kampf();

		
		long[] attHorde = rechner.getAtterHorde();
		long[] deffHorde = rechner.getDeffHorde();
		
		long[] resultAtt =	{0,0,24213,24213,24213,24213,0,0,0,0,0,0,0,0,0,0,0};
						  //{0,0,0		,0	,0		,0,0,0,0,0,0,0,0,0,0,0,0}
		long[] resultDeff = {0,0,0,0,0,0,0,0,0,0,0,0,207,207,0,0,0};
		assertEquals(equals(resultAtt,attHorde),true);
		assertEquals(equals(resultDeff,deffHorde),true);	
		// {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	}
	
	@Test
	void test1gegen1Vorteil() {
		double[] atterHorde = {0,0,20000,0,0,0,0,0,0,0,0,0,0,0,0,0,0};	
		double[] defferHorde = new double[] {0,0,0,0,100000,0,0,0,0,0,0,0,0,0,0,0,0};		

		this.setUpNoHeroes(atterHorde, defferHorde);	
		System.out.println(rechner.kampf());

		
		long[] attHorde = rechner.getAtterHorde();
		long[] deffHorde = rechner.getDeffHorde();
		
		long[] resultAtt =	{0,0,800,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
						  //{0,0,0		,0	,0		,0,0,0,0,0,0,0,0,0,0,0,0}
		long[] resultDeff = {0,0,0,0,99500,0,0,0,0,0,0,0,0,0,0,0,0};
		assertEquals(equals(resultAtt,attHorde),true);
		assertEquals(equals(resultDeff,deffHorde),true);	
	}
	
	@Test
	void testCrankygegenJaegerVorteil() {
		double[] atterHorde = {0,1_486_585,76_110,142_260,815_825,726_551,229_070,179_141,1_848,96_255,0,0,0,0,0,0,0};	
		double[] defferHorde = new double[] {0,796872,83590,71712,142511,35539,215713,0,0,120000,550000,0,0,0,0,0,0};		

		this.initWesen();
		//this.setUpNoHeroes(atterHorde, defferHorde);
		atter = new Held(75,0,75);
		atter.addAngriffsBoni(20);
		atter.addLebensBoni(19);
		atter.setHorde(atterHorde);
		
		deffer = new Held(5,0,62);
		deffer.addVerteidigungsBoni(57.5);
		deffer.addLebensBoni(32.5);
		deffer.setHorde(defferHorde);
		rechner = new Rechner(atter,deffer);
		System.out.println(rechner.kampf());

		
		long[] attHorde = rechner.getAtterHorde();
		long[] deffHorde = rechner.getDeffHorde();
		
		
		Prints.printHorde("Angreifer", attHorde, 0);
		Prints.printHorde("Verteidiger", deffHorde, 0);
		//rechner.printGesamtVerluste();
	}
	
	
	
	
	
	
	
	
	
	
	private boolean equals(long[] array1, long[] array2) {
		
		if(array1.length != array2.length)
			return false;
		
		for(int count = 0; count < array1.length; count++) {
			long t = Math.round(array2[count]);
			
			if(array1[count] != t)
				return false;
		}
		return true;
	}
	
	//atter.setAngriff(0);
			//atter.setLeben(0);
	
	//deffer.setLeben(60);
	//deffer.setBoni(0, 47.5, 16.5);
	
	
	//double[] defferHorde = new double[] {0,0,83590,71712,142511,35539,215713,0,0,0,111648,0,0,0,0,0,0};
	//long[] atterHorde = new long[] ;
			//long[] atterHorde = new long[] {0,145611,110436,82327,463741,557562,0,129577,609034,29235,14398,429473,0,6138,59055,0,0};
}
