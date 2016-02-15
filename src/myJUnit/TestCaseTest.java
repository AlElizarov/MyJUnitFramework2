package myJUnit;

public class TestCaseTest extends MyTestCase {

	public void testSetUp() {
		WasRun test = new WasRun();
		test.run();
		assert ("setUp testMethod tearDown ".equals(test.getLog()));
	}
	
	public void testResult(){
		WasRun test = new WasRun();
		assert ("2 run, 1 failed".equals(test.run()));
	}
	
	public void testFailed(){
		WasRun test = new WasRun();
		assert ("2 run, 1 failed".equals(test.run()));
	}

}
