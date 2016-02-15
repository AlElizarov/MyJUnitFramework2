package myJUnit;

public class TestCaseTest extends MyTestCase {
	
	public void testResult(){
		WasRun test = new WasRun();
		assert ("3 run, 1 failed, 1 failures".equals(test.run().summary()));
	}
	
	public void testFormatting(){
		TestResult result = new TestResult();
		result.testRuned();
		result.testFailed();
		result.testFailure();
		assert("1 run, 1 failed, 1 failures".equals(result.summary()));
	}
	
	public void testSuite(){
		MyTestSuite suite = new MyTestSuite();
		suite.add(new WasRun());
		suite.add(new TestCalc());
		String res = suite.run().summary();
		assert ("5 run, 1 failed, 1 failures".equals(res));
	}

}
