package hr.fer.zemris.java.hw06.observer1;

/**
 * Class that represents a double value observer. Observer that activates
 * everytime the value in the integer storage is changed and prints out the
 * doubled new value. Implements an IntegerStorageObserver interface. Observer
 * deregisters himself when his initially given counter runs out. Every change
 * in the integer storage lowers the counter by 1.
 * 
 * @author Dinz
 *
 */
public class DoubleValue implements IntegerStorageObserver {
	/**
	 * Counter of the observer.
	 */
	private int counter;

	/**
	 * Constructs a new DoubleValue observer with a given counter.
	 * 
	 * @param counter
	 *            Counter.
	 */
	public DoubleValue(int counter) {
		this.counter = counter;
	}

	/**
	 * Prints out the doubled value of the newly changed value and lowers the
	 * counter.
	 */
	@Override
	public void valueChanged(IntegerStorage istorage) {
		if (counter > 0) {
			System.out.println("Double value: " + istorage.getValue() * 2);
			counter--;
		}

	}

	/**
	 * Gets the current number of steps left.
	 * 
	 * @return Current number of steps left.
	 */
	public int getCounter() {
		return this.counter;
	}

}
