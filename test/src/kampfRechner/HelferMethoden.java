package kampfRechner;

public class HelferMethoden {

	public static double sum(double[] sumUp) {
		double sum = 0;
		for (double toAdd : sumUp)
			sum += toAdd;
		return sum;
	}
	
	public static long[] roundAndCut(double[] toRound) {
		long[] newArray = new long[toRound.length];

		for (int count = 0; count < toRound.length; count++) {
			newArray[count] = Math.round(toRound[count]);

		}
		return newArray;
	}
}
