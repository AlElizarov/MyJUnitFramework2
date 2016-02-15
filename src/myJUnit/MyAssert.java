package myJUnit;

public class MyAssert {

	public static void assertEquals(Object expected, Object actual) {
		if(expected.equals(actual)) return;
		throw new AssertionError("expected "+expected+", but was "+actual);
	}

	public static void assertNotEquals(Object expected, Object actual) {
		if(!expected.equals(actual)) return;
		throw new AssertionError("values should be different. Actual: "+actual);
	}

	public static void assertTrue(boolean b) {
		if(b) return;
		throw new AssertionError("not true");
	}

	public static void assertFalse(boolean b) {
		assertTrue(!b);
	}
	
	

}
