package myJUnit;

class TestCaseTest extends MyTestCase {

	public void testResult() {
		WasRun test = new WasRun();
		MyAssert.assertEquals(
				"3 run, 1 failed, 1 failures"
						+ "\nWasRun:\n"
						+ "testBroken: Failed: IndexOutOfBoundsException: Index: 2, Size: 0\ntestFailure: Failure: expected 7, but was 5\ntestMethod: OK\n",
				test.run().summary());
	}

	public void testSuite() {
		MyTestSuite suite = new MyTestSuite();
		suite.add(new WasRun());
		suite.add(new TestCalc());
		String res = "7 run, 1 failed, 1 failures\n"
				+ "TestCalc:\ntestDivide: OK\ntestMinus: OK\ntestMult: OK\ntestPlus: OK\n"
				+ "WasRun:\ntestBroken: Failed: IndexOutOfBoundsException: Index: 2, Size: 0\ntestFailure: Failure: expected 7, but was 5\ntestMethod: OK\n";
		MyAssert.assertEquals(res, suite.run().summary());
	}

}
