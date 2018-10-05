package hr.fer.zemris.java.hw06.demo2;

/**
 * Class that demonstrates the use of PrimesCollection class which calculates
 * prime numbers. In this example which follows the one on the official task
 * directions, the program should print out first 8 prime numbers. The number is
 * adjustable manually
 * 
 * @author Dinz
 *
 */
public class PrimesDemo1 {
	/**
	 * Class that executes the class.
	 * 
	 * @param args
	 *            Arguments from the command line.
	 */
	public static void main(String[] args) {
		PrimesCollection primesCollection = new PrimesCollection(8); // 8: how many of them
		for (Integer prime : primesCollection) {
			System.out.println("Got prime: " + prime);
		}

	}

}
