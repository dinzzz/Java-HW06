package hr.fer.zemris.java.hw06.demo2;

import java.util.Iterator;

/**
 * Class that represents the calculation of the first "n" prime numbers. Level
 * "n" is given to the class as an argument.
 * 
 * @author Dinz
 *
 */
public class PrimesCollection implements Iterable<Integer> {
	/**
	 * Level or the number of prime numbers the class has to produce.
	 */
	private int level;

	/**
	 * Constructs a new PrimesCollection class.
	 * 
	 * @param level
	 *            Level
	 */
	public PrimesCollection(int level) {
		if(level < 1) {
			throw new IllegalArgumentException("Level must be atleast 1.");
		}
		this.level = level;
	}

	/**
	 * Implements a new iterator on the PrimesCollection class.
	 */
	@Override
	public Iterator<Integer> iterator() {
		return new PrimesIterator();
	}

	/**
	 * Inner class that represents an iterator which iterates through prime numbers.
	 * 
	 * @author Dinz
	 *
	 */
	private class PrimesIterator implements Iterator<Integer> {
		/**
		 * Counter of already iterated prime numbers.
		 */
		int counter = 0;
		/**
		 * Last prime number iterated.
		 */
		int prime = 2;

		/**
		 * Checks if there is need to iterate next prime number.
		 */
		@Override
		public boolean hasNext() {
			return counter < level;
		}

		/**
		 * Gets the next prime number.
		 */
		@Override
		public Integer next() {
			if (counter == 0) {
				counter++;
				return 2;
			}

			while (true) {
				prime++;

				if (isPrime(prime)) {
					counter++;
					return prime;
				}

			}

		}

		/**
		 * Checks if the number is prime.
		 * 
		 * @param number
		 *            Number to be checked.
		 * @return True if the number is prime, false otherwise.
		 */
		private boolean isPrime(int number) {
			if (number % 2 == 0) {
				return false;
			}
			for (int i = 3; i * i <= number; i += 2) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
