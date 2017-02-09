package stats.dice;
import random.dice.PairOfDice;
import stats.StatCalc;

public class EE5_3 {

	/**
	 * The number of times that the experiment "roll for a given total" is to be
	 * repeated. The program performs this many experiments, and prints the
	 * average of the result, for each possible roll value,
	 */
	public static final int numberOfRolls = 10000;

	public static void main(String[] args) {
		
		System.out.println("Average Number of Rolls     Standard Deviation	Max Number Of Rolls");
		System.out.println("-----------------------     ------------------	-------------------");
		
		for (int total = 2; total <= 12; total++) {
			StatCalc sc = new StatCalc();
			for (int i = 0; i < numberOfRolls; i++) {
				sc.enter(rollFor(total));
			}
		System.out.printf("%22.2f",sc.getMean());
		System.out.printf("%10.2f",sc.getStandardDeviation());
		System.out.printf("%25.2f\n",sc.getMax());
		}
		}


	/**
	 * Function that rolls a pair of dice until their sum reaches a specific number
	 * and then returns how many rolls it took to get to that number
	 * 
	 * @param int (number)
	 *            the number we are rolling for
	 * @return the number of times the dice are rolled to get the number we want
	 *         occurs
	 * @throws IllegalArgumentException
	 *             If number is not within the possible results of the sum of the roll of two dice
	 */
	public static int rollFor(int number) {
		if (number < 2 || number > 12)
			throw new IllegalArgumentException("Impossible total for a pair of dice.");

		PairOfDice pd = new PairOfDice();
		int rollCt;
		rollCt = 0;
		do {
			pd.roll();
			rollCt++;
		} while (pd.getTotal() != number);
		return rollCt;
	}
}
