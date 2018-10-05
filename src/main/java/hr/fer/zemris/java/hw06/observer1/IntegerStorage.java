package hr.fer.zemris.java.hw06.observer1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Class that represents an integer storage - an element which stores one
 * integer value and has its observers. Everytime the value inside the storage
 * changes, the storage has no notify all of the observers which provide their
 * actions.
 * 
 * @author Dinz
 *
 */
public class IntegerStorage {
	/**
	 * Value inside the storage.
	 */
	private int value;
	/**
	 * List of observers.
	 */
	private List<IntegerStorageObserver> observers = new ArrayList<>(); // use ArrayList here!!!
	/**
	 * Constructs a new integerStorage
	 * @param initialValue Initial value in the storage.
	 */
	public IntegerStorage(int initialValue) {
		this.value = initialValue;
	}
	/**
	 * Adds a new observer.
	 * @param observer New observer.
	 */
	public void addObserver(IntegerStorageObserver observer) {
		if(!observers.contains(observer)) {
			observers.add(observer);
		}
	}
	/**
	 * Removes the observer from the storage.
	 * @param observer Observer to be removed.
	 */
	public void removeObserver(IntegerStorageObserver observer) {
		observers.remove(observer);
	}
	/**
	 * Removes all the observers from the storage.
	 */
	public void clearObservers() {
		observers.clear();
	}
	/**
	 * Returns the value from the storage.
	 * @return Value from the storage.
	 */
	public int getValue() {
		return value;
	}
	/**
	 * Sets the value in the storage.
	 * @param value New value.
	 */
	public void setValue(int value) {
		// Only if new value is different than the current value:
		if (this.value != value) {
			// Update current value
			this.value = value;
			// Notify all registered observers
			if (observers != null) {
				Iterator<IntegerStorageObserver> iter = observers.iterator();
				while(iter.hasNext()) {
					IntegerStorageObserver observer = iter.next();
					observer.valueChanged(this);
					
					if(observer instanceof DoubleValue) {
						DoubleValue obs = (DoubleValue)observer;
						if(obs.getCounter() == 0) {
							iter.remove();
						}
					}
				}
			}
		}
	}
}
