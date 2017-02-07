import random.dice.PairOfDice;
import stats.StatCalc;

public class EE5_3 {

	/**
	 * The number of times that the experiment "roll for a given total" is to be
	 * repeated. The program performs this many experiments, and prints the
	 * average of the result, for each possible roll value,
	 */
	public static final int NUMBER_OF_EXPERIMENTS = 10000;

	public static void main(String[] args) {
		double average; // The average number of rolls to get a given total.
		System.out.println("Average Number of Rolls     Standard Deviation	Max Number Of Rolls");
		System.out.println("-----------------------     ------------------	-------------------");
		for (int dice = 2; dice <= 12; dice++) {
			StatCalc sc = new StatCalc();
			sc.enter(rollFor(dice));
			System.out.printf("%.2f",sc.getMean());
			System.out.printf("%10.2f\n",sc.getStandardDeviation());
			

			
		}
	}


	/**
	 * Simulates rolling a pair of dice until a given total comes up.
	 * Precondition: The desired total is between 2 and 12, inclusive.
	 * 
	 * @param N
	 *            the total that we want to get on the dice
	 * @return the number of times the dice are rolled before the desired total
	 *         occurs
	 * @throws IllegalArgumentException
	 *             if the parameter, N, is not a number that could possibly come
	 *             up on a pair of dice
	 */
	public static int rollFor(int N) {
		if (N < 2 || N > 12)
			throw new IllegalArgumentException("Impossible total for a pair of dice.");

		PairOfDice pd = new PairOfDice();
		int roll; // Total showing on dice.
		int rollCt; // Number of rolls made.
		rollCt = 0;
		do {
			pd.roll();
			roll = pd.getTotal();
			rollCt++;
		} while (roll != N);
		return rollCt;
	}
}
