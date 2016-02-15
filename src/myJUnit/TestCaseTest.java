package myJUnit;

public class TestCaseTest extends MyTestCase {

	public void testResult() {
		WasRun test = new WasRun();
		assert ("3 run, 1 failed, 1 failures\ntestMethod: OK\ntestBroken: Failed\ntestFailure: Failure\n"
				.equals(test.run().summary()));
	}

	public void testSuite() {
		MyTestSuite suite = new MyTestSuite();
		suite.add(new WasRun());
		suite.add(new TestCalc());
		String res = suite.run().summary();
		assert ("7 run, 1 failed, 1 failures".equals(res));
	}

}
