package hr.fer.zemris.java.hw06.demo2;

/**
 * Class that demonstrates the use of the PrimesCollection class. In this
 * scenario, which follows the scenario written on the official task directions,
 * the class calculates and prints out the cartesian product between first two
 * prime numbers. That level is adjustable manually.
 * 
 * @author Dinz
 *
 */
public class PrimesDemo2 {

	public static void main(String[] args) {
		PrimesCollection primesCollection = new PrimesCollection(2);
		for (Integer prime : primesCollection) {
			for (Integer prime2 : primesCollection) {
				System.out.println("Got prime pair: " + prime + ", " + prime2);
			}
		}
	}

}
