package hr.fer.zemris.java.custom.scripting.exec;

import org.junit.Test;
import org.junit.Assert;

public class ValueWrapperTest {
	private static final double DELTA = 0.0005;

	@Test
	public void intintAddTest() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(5));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));
		v1.add(v2.getValue());

		Integer expected = 7;
		Integer actual = (Integer) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
	}

	@Test
	public void intintSubTest() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(5));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));
		v1.subtract(v2.getValue());

		Integer expected = 3;
		Integer actual = (Integer) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
	}

	@Test
	public void intintMulTest() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(5));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));
		v1.multiply(v2.getValue());

		Integer expected = 10;
		Integer actual = (Integer) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
	}

	@Test
	public void intintCMPTest() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(5));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));

		Integer expected = 5;
		Integer actual = (Integer) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		Integer expected2 = 1;
		Integer actual2 = v1.numCompare(v2.getValue());

		Integer expected3 = -1;
		Integer actual3 = v2.numCompare(v1.getValue());

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
	}

	@Test
	public void intintDivTest() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(5));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));
		v1.divide(v2.getValue());

		Integer expected = 2;
		Integer actual = (Integer) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void intintDivZeroTest() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(5));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(0));
		v1.divide(v2.getValue());
	}

	@Test
	public void dbldblAddTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Double.valueOf(2.2));
		ValueWrapper v3 = new ValueWrapper(Double.valueOf(2.4));
		v1.add(v2.getValue());

		Double expected = 7.6;
		Double actual = (Double) v1.getValue();

		Double expected1 = 2.2;
		Double actual1 = (Double) v2.getValue();

		v1.add(v3.getValue());

		Double expected2 = 10.0;
		Double actual2 = (Double) v1.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1, DELTA);
		Assert.assertEquals(expected2, actual2, DELTA);
	}

	@Test
	public void dbldblSubTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Double.valueOf(2.2));
		v1.subtract(v2.getValue());

		Double expected = 3.2;
		Double actual = (Double) v1.getValue();

		Double expected1 = 2.2;
		Double actual1 = (Double) v2.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1, DELTA);
	}

	@Test
	public void dbldblMulTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Double.valueOf(2.2));
		v1.multiply(v2.getValue());

		Double expected = 11.88;
		Double actual = (Double) v1.getValue();

		Double expected1 = 2.2;
		Double actual1 = (Double) v2.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1, DELTA);
	}

	@Test
	public void dbldblCmpTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Double.valueOf(2.2));

		Double expected = 5.4;
		Double actual = (Double) v1.getValue();

		Double expected1 = 2.2;
		Double actual1 = (Double) v2.getValue();

		Integer expected2 = 1;
		Integer actual2 = v1.numCompare(v2.getValue());

		Integer expected3 = -1;
		Integer actual3 = v2.numCompare(v1.getValue());

		Integer expected4 = 0;
		Integer actual4 = v1.numCompare(v1.getValue());

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1, DELTA);
		Assert.assertEquals(expected2, actual2, DELTA);
		Assert.assertEquals(expected3, actual3, DELTA);
		Assert.assertEquals(expected4, actual4, DELTA);
	}

	@Test
	public void dbldblDivTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.0));
		ValueWrapper v2 = new ValueWrapper(Double.valueOf(2.0));
		ValueWrapper v3 = new ValueWrapper(Double.valueOf(1.25));
		v1.divide(v2.getValue());

		Double expected = 2.5;
		Double actual = (Double) v1.getValue();

		Double expected1 = 2.0;
		Double actual1 = (Double) v2.getValue();

		v1.divide(v3.getValue());

		Double expected2 = 2.0;
		Double actual2 = (Double) v1.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1, DELTA);
		Assert.assertEquals(expected2, actual2, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dbldblDivZeroTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.0));
		ValueWrapper v2 = new ValueWrapper(Double.valueOf(0.0));
		v1.divide(v2.getValue());
	}

	@Test
	public void intdblAddTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));
		v1.add(v2.getValue());

		Double expected = 7.4;
		Double actual = (Double) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		v2.add(v1.getValue());

		Double expected2 = 9.4;
		Double actual2 = (Double) v2.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2, DELTA);
	}

	@Test
	public void intdblSubTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));
		v1.subtract(v2.getValue());

		Double expected = 3.4;
		Double actual = (Double) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		v2.subtract(v1.getValue());

		Double expected2 = -1.4;
		Double actual2 = (Double) v2.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2, DELTA);
	}

	@Test
	public void intdblMulTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));
		v1.multiply(v2.getValue());

		Double expected = 10.8;
		Double actual = (Double) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		v2.multiply(v1.getValue());

		Double expected2 = 21.6;
		Double actual2 = (Double) v2.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2, DELTA);
	}

	@Test
	public void intdblCmpTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));

		Integer expected2 = 1;
		Integer actual2 = v1.numCompare(v2.getValue());

		Integer expected3 = -1;
		Integer actual3 = v2.numCompare(v1.getValue());

		Integer expected4 = 0;
		Integer actual4 = v2.numCompare(v2.getValue());

		Double expected = 5.4;
		Double actual = (Double) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
		Assert.assertEquals(expected4, actual4);
	}

	@Test
	public void intdblDivTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(2));
		v1.divide(v2.getValue());

		Double expected = 2.7;
		Double actual = (Double) v1.getValue();

		Integer expected1 = 2;
		Integer actual1 = (Integer) v2.getValue();

		v2.divide(v1.getValue());

		Double expected2 = 2 / 2.7;
		Double actual2 = (Double) v2.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void intdblDivZeroTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(5.4));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(0));
		v1.divide(v2.getValue());
	}

	@Test(expected = IllegalArgumentException.class)
	public void dblIntDivZeroTest() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(0));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(1));
		v2.divide(v1.getValue());
	}

	@Test
	public void nullnullTest() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(null);
		v1.add(v2.getValue());

		Integer expected = 0;
		Integer actual = (Integer) v1.getValue();

		Object expected1 = null;
		Object actual1 = v2.getValue();

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
	}
	
	@Test
	public void nullnullCmpTest() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(null);
		
		int expected = 0;
		int actual = v1.numCompare(v2.getValue());
		
		Object expectedNull = null;
		Object actual1 = v1.getValue();
		Object actual2 = v2.getValue();
		
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expectedNull, actual1);
		Assert.assertEquals(expectedNull, actual2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullnullDivTest() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(null);
		v1.divide(v2.getValue());
	}

	@Test
	public void nullNumaddTest() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(3));
		ValueWrapper v3 = new ValueWrapper(null);
		v1.add(v2.getValue());

		Integer expected = 3;
		Integer actual = (Integer) v1.getValue();

		Integer expected1 = 3;
		Integer actual1 = (Integer) v2.getValue();

		v1.add(v3.getValue());

		Integer expected2 = 3;
		Integer actual2 = (Integer) v1.getValue();

		Object expected3 = null;
		Object actual3 = v3.getValue();

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
	}

	@Test
	public void nullNumSubTest() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(3));
		ValueWrapper v3 = new ValueWrapper(null);
		v1.subtract(v2.getValue());

		Integer expected = -3;
		Integer actual = (Integer) v1.getValue();

		Integer expected1 = 3;
		Integer actual1 = (Integer) v2.getValue();

		v1.add(v3.getValue());

		Integer expected2 = -3;
		Integer actual2 = (Integer) v1.getValue();

		Object expected3 = null;
		Object actual3 = v3.getValue();

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
	}

	@Test
	public void nullNumMulTest() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(3));
		ValueWrapper v3 = new ValueWrapper(null);
		v1.multiply(v2.getValue());

		Integer expected = 0;
		Integer actual = (Integer) v1.getValue();

		Integer expected1 = 3;
		Integer actual1 = (Integer) v2.getValue();

		v1.multiply(v3.getValue());

		Integer expected2 = 0;
		Integer actual2 = (Integer) v1.getValue();

		Object expected3 = null;
		Object actual3 = v3.getValue();

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
	}

	@Test
	public void nullNumDivTest() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(3));
		v1.divide(v2.getValue());

		Integer expected = 0;
		Integer actual = (Integer) v1.getValue();

		Integer expected1 = 3;
		Integer actual1 = (Integer) v2.getValue();

		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullNumdivZeroTest() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(3));
		v2.divide(v1.getValue());
	}

	@Test(expected = RuntimeException.class)
	public void wrongArgTest() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper("Trifon Ivanov");
		v2.divide(v1.getValue());
	}

	@Test(expected = RuntimeException.class)
	public void wrongCurrTest() {
		ValueWrapper v1 = new ValueWrapper("Pierluigi Colina");
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(7));
		v2.divide(v1.getValue());
	}

	@Test
	public void stringParsingTest() {
		ValueWrapper v1 = new ValueWrapper("7.0");
		ValueWrapper v2 = new ValueWrapper("3.2");
		ValueWrapper v3 = new ValueWrapper("12");
		ValueWrapper v4 = new ValueWrapper("6");
		ValueWrapper v5 = new ValueWrapper("1.2E1");

		v1.add(v2.getValue());
		Double expected = 10.2;
		Double actual = (Double) v1.getValue();
		String expected1 = "3.2";
		String actual1 = (String) v2.getValue();

		v2.add(v1.getValue());
		Double expected2 = 13.4;
		Double actual2 = (Double) v2.getValue();

		v3.add(v4.getValue());
		Integer expected3 = 18;
		Integer actual3 = (Integer) v3.getValue();
		String expected4 = "6";
		String actual4 = (String)v4.getValue();
		
		v4.add(v5.getValue());
		Double expected5 = 18.0;
		Double actual5 = (Double)v4.getValue();
		String expected6 = "1.2E1";
		String actual6 = (String)v5.getValue();

		Assert.assertEquals(expected, actual, DELTA);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2, DELTA);
		Assert.assertEquals(expected3, actual3);
		Assert.assertEquals(expected4, actual4);
		Assert.assertEquals(expected5, actual5, DELTA);
		Assert.assertEquals(expected6, actual6);
	}

}
