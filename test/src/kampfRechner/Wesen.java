package kampfRechner;



public class Wesen {

	private static Einheit[] wesen;
	private static Einheit[] wächter;
	private static double[][] boni;
	
	public Wesen()
	{
		
		wesen = new Einheit[17];
		wächter = new Einheit[5];
		Wesen.createUnits();
		Wesen.createGuardians();
		Wesen.createBoni();
	}
	
	
	
	

	
	
	
	public static void createUnits() {
		wesen[0] = new Einheit(1, 1, 80, 100, 2251, 3000,10, "Dracheneier");
		wesen[1] = new Einheit(0, 0, 20, 2000, 17, 10,2, "Einhornwagen");
		wesen[2] = new Einheit(1, 1, 25, 0, 5, 3,4, "Kobold");
		wesen[3] = new Einheit(3,3,9,60,3,3,4,"Kinder der Macht");
		wesen[4] = new Einheit(2,2,40,0,10,5,2,"Eiskrieger");	
		wesen[5] = new Einheit(7,7,22,140,19,7,2, "Hysterische Zentaurin");	
		wesen[6] = new Einheit(4,4,85,0,19,10,3,"Kriegerpriester");
		wesen[7] = new Einheit(15,13,42,260,23,13,2,"Wilde Zentauren");
		wesen[8] = new Einheit(0,10,100,0,33,20,2,"Sturmfeen");
		wesen[9] = new Einheit(25,25,25,180,30,20,2,"Feuerfeen");
		wesen[10] = new Einheit(7,8,180,0,35,19,3,"Axtschwingende Zwerge");
		wesen[11] = new Einheit(22,24,80,420,40,21,3,"Elfenbogenschützen");
		wesen[12] = new Einheit(12,10,250,0,49,25,4,"Doppelaxtzwerge");
		wesen[13] = new Einheit(53,53,160,840,77,42,4,"Baumriesen");
		wesen[14] = new Einheit(25,25,600,580,105,58,2,"Singende Halbriesen");
		wesen[15] = new Einheit(82,82,255,1300,122,65,2,"Elfenmagier");
		wesen[16] = new Einheit(34,34,1000,0,154,80,4,"Steinwerfende Bergtrolle");	
	}
	
	private static void createGuardians() {
		wächter[0] = new Einheit(1, 1, 2, 100, 1, -1, 2,"Wurzelwichte");
		wächter[1] = new Einheit(4, 4, 60, 80, 16, -1, 2,"Midgardschlangen");
		wächter[2] = new Einheit(8, 8, 180, 60, 40, -1, 2,"Feuerteufel");
		wächter[3] = new Einheit(14, 14, 300, 20, 60, -1, 2,"Zyklopen");
		wächter[4] = new Einheit(20, 20, 540, 10, 90, -1, 2,"Todesengel");
	}
	
	private static void createBoni() {
		boni = new double[][]	 
		{	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //Dracheneier
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//Einhornwagen
			{0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,2},//Kobolde
			{0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,4},//Kinder
			{0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,4,0},//Eiskrieger
			{0,0,4,2,0,0,0,0,0,0,0,0,0,0,0,0,0},//Hysterische
			{0,0,0,4,2,0,0,0,0,0,0,0,0,0,0,0,0},//Priester
			{0,0,0,0,0,2,4,0,0,0,0,0,0,0,0,0,0},//Wilde
			{0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,2},//Sturmfeen
			{0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,3,0},//Feuerfeen
			{0,0,0,0,0,4,2,0,0,0,0,0,0,0,0,0,0},//Axtis
			{0,0,0,0,0,0,0,2,0,0,4,0,0,0,0,0,0},//Elfenbogis
			{0,0,0,0,0,0,0,4,0,0,2,0,0,0,0,0,0},//Doppelaxtis
			{0,0,0,0,0,0,0,0,0,0,0,2,4,0,0,0,0},//Baumis
			{0,0,0,0,0,0,0,0,0,0,0,4,2,0,0,0,0},//Singende
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,4,0,0},//Elfenmagier
			{0,0,0,0,0,0,0,0,0,0,0,0,0,4,2,0,0},//Trolle
			};
		
	}
	
	public static double hatBonus(int atterNumber, int defferNumber) {
		double dmg = boni[atterNumber][defferNumber];
		if(dmg != 0)
			return dmg;
		return 1;
	}
	
	public static int getEinheitenPunkte(int nummer) {
		return wesen[nummer].getPunkte();
	}
	
	public static int getEinheitenAngriff(int nummer) {
		return wesen[nummer].getAngriff();
	}
	
	public static int getEinheitenVerteidigung(int nummer) {
		return wesen[nummer].getVerteidigung();
	}
	
	public static int getEinheitenLeben(int nummer) {
		return wesen[nummer].getLeben();
	}

	public static String getEinheitenName(int nummer) {
		return wesen[nummer].getName();
	}
}
