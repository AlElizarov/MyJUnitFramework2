package myJUnit;

public class TestCaseTest extends MyTestCase {

	public void testSetUp() {
		WasRun test = new WasRun();
		test.run();
		assert ("setUp testMethod ".equals(test.getLog()));
	}

}
