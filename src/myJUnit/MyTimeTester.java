package myJUnit;

public class MyTimeTester extends MyTestCase {

	private long timeout;

	public MyTimeTester(long timeout) {
		this.timeout = timeout;
	}

	public void testTime() {
		long startTime = System.currentTimeMillis();
		doSomething();
		long endTime = System.currentTimeMillis() - startTime;
		if (endTime > timeout) {
			throw new AssertionError("overtime: expected " + timeout
					+ "ms, but was " + endTime + "ms");
		}
	}

	protected void doSomething() {

	}

}
