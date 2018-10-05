package hr.fer.zemris.java.hw06.observer1;

/**
 * Interface that defines an integer storage observer. Observers provide an
 * action everytime a value changes in the mentioned storage.
 * 
 * @author Dinz
 *
 */
public interface IntegerStorageObserver {
	/**
	 * Action to be made when the value changes.
	 * 
	 * @param istorage
	 *            Integer storage.
	 */
	public void valueChanged(IntegerStorage istorage);
}