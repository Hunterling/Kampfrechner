package kampfRechner;

public class Prints {
	

	
	
	public Prints() {
			
	}
	
	public void printHorde(String name, double[] anzahl, double gesamtLeben) {
		
		System.out.println("Hordenaufzählung von : " + name + " mit Gesamtleben: " + gesamtLeben);
		
		for(int i = 1;i  < 17;i++) {
			if(anzahl[i] != 0)
			System.out.println(Wesen.getEinheitenName(i) + " :" + anzahl[i]);
		}	
	}
	
	public static void printHorde(String name, long[] anzahl, long gesamtLeben) {
		
		System.out.println("Hordenaufzählung von : " + name + " mit Gesamtleben: " + gesamtLeben);
		
		for(int i = 1;i  < 17;i++) {
			if(anzahl[i] != 0)
			System.out.println(Wesen.getEinheitenName(i) + " :" + anzahl[i]);
		}	
	}
}
