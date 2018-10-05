package hr.fer.zemris.java.hw06.observer2;

/**
 * Class that represents an occurance of change in the integer storage.
 * 
 * @author Dinz
 *
 */
public class IntegerStorageChange {
	/**
	 * Integer storage.
	 */
	private IntegerStorage iStorage;
	/**
	 * Old value.
	 */
	private int oldValue;
	/**
	 * New value.
	 */
	private int newValue;

	/**
	 * Constructs a new IntegerStorageChange.
	 * 
	 * @param iStorage
	 *            Integer storage.
	 * @param oldValue
	 *            Old value.
	 * @param newValue
	 *            New value.
	 */
	public IntegerStorageChange(IntegerStorage iStorage, int oldValue, int newValue) {
		this.iStorage = iStorage;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	/**
	 * Gets the integer storage.
	 * 
	 * @return Integer storage.
	 */
	public IntegerStorage getiStorage() {
		return iStorage;
	}

	/**
	 * Gets the old value.
	 * 
	 * @return Old value.
	 */
	public int getOldValue() {
		return oldValue;
	}

	/**
	 * Gets the new value.
	 * 
	 * @return New value.
	 */
	public int getNewValue() {
		return newValue;
	}

}
