package hr.fer.zemris.java.custom.scripting.exec;

import org.junit.Test;
import org.junit.Assert;

public class ObjectMultistackTest {
	
	@Test
	public void pushTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("Mercedes", new ValueWrapper("SLR"));
		
		String expected = "SLR";
		String actual = (String)stack.peek("Mercedes").getValue();
		
		boolean expected1 = false;
		boolean actual1 = stack.isEmpty("Mercedes");
		
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
	}
	
	@Test
	public void pushMultipleTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("Mercedes", new ValueWrapper("SLR"));
		stack.push("Mercedes", new ValueWrapper("SLS"));
		stack.push("Audi", new ValueWrapper("A7"));
		
		String expected = "SLS";
		String actual = (String)stack.peek("Mercedes").getValue();
		
		stack.pop("Mercedes");
		String expected2 = "SLR";
		String actual2 = (String)stack.peek("Mercedes").getValue();
		
		String expected3 = "A7";
		String actual3 = (String)stack.peek("Audi").getValue();
		
		boolean expected1 = false;
		boolean actual1 = stack.isEmpty("Mercedes");
		
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
	}
	
	@Test
	public void popFirstTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("Mercedes", new ValueWrapper("SLR"));
		
		boolean expected1 = false;
		boolean actual1 = stack.isEmpty("Mercedes");
		
		String actual = (String)stack.pop("Mercedes").getValue();
		String expected = "SLR";
		
		boolean expected2 = true;
		boolean actual2 = stack.isEmpty("Mercedes");
		
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
	}
	
	@Test
	public void popSecondTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("Mercedes", new ValueWrapper("SLR"));
		stack.push("Mercedes", new ValueWrapper("SLS"));
		
		boolean expected1 = false;
		boolean actual1 = stack.isEmpty("Mercedes");
		
		String actual = (String)stack.pop("Mercedes").getValue();
		String expected = "SLS";
		
		boolean expected2 = false;
		boolean actual2 = stack.isEmpty("Mercedes");
		
		String actual4 = (String)stack.pop("Mercedes").getValue();
		String expected4 = "SLR";
		
		boolean expected3 = true;
		boolean actual3 = stack.isEmpty("Mercedes");
		
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
		Assert.assertEquals(expected4, actual4);
	}
	
	@Test
	public void popThirdTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("Mercedes", new ValueWrapper("SLR"));
		stack.push("Mercedes", new ValueWrapper("SLS"));
		stack.push("Mercedes", new ValueWrapper("AMG GT"));
		
		boolean expected1 = false;
		boolean actual1 = stack.isEmpty("Mercedes");
		
		String actual = (String)stack.pop("Mercedes").getValue();
		String expected = "AMG GT";
		
		boolean expected2 = false;
		boolean actual2 = stack.isEmpty("Mercedes");
		
		String actual4 = (String)stack.pop("Mercedes").getValue();
		String expected4 = "SLS";
		
		String actual5 = (String)stack.pop("Mercedes").getValue();
		String expected5 = "SLR";
		
		boolean expected3 = true;
		boolean actual3 = stack.isEmpty("Mercedes");
		
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
		Assert.assertEquals(expected4, actual4);
		Assert.assertEquals(expected5, actual5);
	}
	
	@Test
	public void peekTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("Mercedes", new ValueWrapper("SLR"));
		
		String expected = "SLR";
		String actual = (String)stack.peek("Mercedes").getValue();
		
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isEmptyTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("Mercedes", new ValueWrapper("SLR"));
		
		boolean expected1 = false;
		boolean actual1 = stack.isEmpty("Mercedes");
		
		stack.pop("Mercedes");	
		
		boolean expected2 = true;
		boolean actual2 = stack.isEmpty("Mercedes");
		
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
	}
	
	@Test(expected = EmptyStackException.class)
	public void emptyStackExTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.pop("Mercedes");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullKeyTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push(null, new ValueWrapper("SLR"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullWrapperTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("Mercedes", null);
	}
	
	@Test
	public void nullWrappedTest() {
		ObjectMultistack stack = new ObjectMultistack();
		stack.push("Mercedes", new ValueWrapper(null));
		
		boolean expected = false;
		boolean actual = stack.isEmpty("Mercedes");
		
		Object expected1 = null;
		Object actual1 = stack.pop("Mercedes").getValue();
		
		Assert.assertEquals(expected, actual);
		Assert.assertEquals(expected1, actual1);
	}

}
