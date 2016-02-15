package myJUnit;

public class TestCaseTest extends MyTestCase {
	
	public void testResult(){
		WasRun test = new WasRun();
		assert ("2 run, 1 failed, 0 failures".equals(test.run()));
	}

}
