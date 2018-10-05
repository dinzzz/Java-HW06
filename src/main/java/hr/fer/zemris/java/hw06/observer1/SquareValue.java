package hr.fer.zemris.java.hw06.observer1;

/**
 * Class that represents a SquareValue observer. Observer that prints out the
 * new value and its square value everytime the value is changed in the integer
 * storage.
 * 
 * @author Dinz
 *
 */
public class SquareValue implements IntegerStorageObserver {
	/**
	 * Action that prints out the new changed value and it's square value.
	 */
	@Override
	public void valueChanged(IntegerStorage istorage) {
		System.out.println(
				"Provided new value : " + istorage.getValue() + ", square is " + Math.pow(istorage.getValue(), 2));

	}

}
