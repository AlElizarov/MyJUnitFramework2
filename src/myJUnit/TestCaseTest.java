package myJUnit;

public class TestCaseTest extends MyTestCase {

	public void testResult() {
		WasRun test = new WasRun();
		//System.out.println(test.run().summary());
		assert ("3 run, 1 failed, 1 failures\nWasRun:\ntestBroken: Failed\ntestFailure: Failure\ntestMethod: OK\n"
				.equals(test.run().summary()));
	}

	public void testSuite() {
		MyTestSuite suite = new MyTestSuite();
		suite.add(new WasRun());
		suite.add(new TestCalc());
		//System.out.println(suite.run().summary());
		String res = "7 run, 1 failed, 1 failures\n"
				+"TestCalc:\ntestDivide: OK\ntestMinus: OK\ntestMult: OK\ntestPlus: OK\n"
				+ "WasRun:\ntestBroken: Failed\ntestFailure: Failure\ntestMethod: OK\n";
		assert (res.equals(suite.run().summary()));
	}

}
