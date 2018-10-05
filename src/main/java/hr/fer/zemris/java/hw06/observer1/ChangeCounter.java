package hr.fer.zemris.java.hw06.observer1;

/**
 * Class that represents a counter for changes made in the integer storage. It
 * implements IntegerStorageObserver interface as one of the observers for the
 * mentioned storage.
 * 
 * @author Dinz
 *
 */
public class ChangeCounter implements IntegerStorageObserver {
	/**
	 * Change counter.
	 */
	private int changeCounter = 0;

	/**
	 * Prints out the current number of changes after the value has been changed.
	 */
	@Override
	public void valueChanged(IntegerStorage istorage) {
		System.out.println("Number of value changes since tracking: " + ++changeCounter);

	}

}
